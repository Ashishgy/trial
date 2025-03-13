from flask import Flask, jsonify, make_response
from flask import request
import pickle
import keras
from keras import utils
from keras.models import Sequential
from keras.models import load_model
from keras.layers import Dense, Activation, Dropout
from keras.layers import BatchNormalization
from keras.optimizers import Adam
from tensorflow.keras.layers import Input
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as pltn
import numpy as np
import pandas as pd
from sklearn.preprocessing import normalize
import tensorflow as tf
import requests
import os
import time
import io
import json
from flask_cors import CORS, cross_origin

updated = [0, 0, 0]
rejected = []
logs = []
num_rounds = 1
rounds_counter = 1


def create_model():
    model = Sequential()
    model.add(Input(shape=(4,)))
    model.add(Dense(1000, activation='relu'))
    model.add(Dense(500, activation='relu'))
    model.add(Dense(300, activation='relu'))
    model.add(Dropout(0.2))
    model.add(Dense(3, activation='softmax'))
    model.compile(loss='categorical_crossentropy', optimizer=Adam(
        learning_rate=0.01), metrics=['accuracy'])
    model.summary()
    return model


def save_global_updates(model, additional_info=None):
    client_updates = {"weights": model.get_weights()}
    if additional_info:
        client_updates.update(additional_info)
    with open(f"global_update.pkl", "wb") as f:
        pickle.dump(client_updates, f)


def create_global_model():
    model = Sequential()
    model.add(Dense(1000, input_dim=4, activation='relu'))
    model.add(Dense(500, activation='relu'))
    model.add(Dense(300, activation='relu'))
    model.add(Dropout(0.2))
    model.add(Dense(3, activation='softmax'))
    model.compile(loss='categorical_crossentropy',
                  optimizer='adam', metrics=['accuracy'])
    return model


def aggregate_client_updates(client_update_files):
    all_client_weights = []
    for file_path in client_update_files:
        with open(file_path, "rb") as f:
            client_updates = pickle.load(f)
        client_weights = client_updates["weights"]
        all_client_weights.append(client_weights)
    aggregated_weights = [sum(weights) / len(weights)
                          for weights in zip(*all_client_weights)]
    return aggregated_weights


def get_size_in_mb(text):
    """
    Calculates the size of a string in megabytes (MB).

    Args:
        text: The string to calculate the size for.

    Returns:
        The size of the string in megabytes, rounded to two decimal places.
    """
    # Get the size of the string in bytes
    string_size_bytes = len(text.encode('utf-8'))

    # Convert bytes to megabytes and round to two decimal places
    size_in_mb = round(string_size_bytes / (1024 * 1024), 2)

    return size_in_mb
# 3. Federated Learning Loop:


def federated_training(global_model):
  global logs
  global rounds_counter
  
  print(f"-- Round {rounds_counter} --")
  logs.append(f"-- Round {rounds_counter } --")
  while not all(i == 0 for i in updated):
    time.sleep(2)
  with open('./global_update.pkl', 'rb') as file:
    loaded_data = pickle.load(file)
    url = 'http://host.docker.internal:9081/train'
    print(get_size_in_mb(str(pickle.dumps(loaded_data))))
    headers = {'Content-Type': ': application/json'}
    response = requests.post(url, json={'value':str(pickle.dumps(loaded_data),'latin1'),'data':{'client_id':0,'epochs':3}}) 
    fileModel = open('sent.txt','w')
    fileModel.write(str(pickle.dumps(loaded_data),'latin1'))
    fileModel.close() 
    if response.status_code == 200:
        print("File successfully sent to API.")
        logs.append("File successfully sent to API.")
    else:
        print("Error occurred while sending file to API. Status code:", response.status_code)
        return {'value':str(pickle.dumps(loaded_data),'latin1'),'data':{'client_id':i,'epochs':3}}
  
  return "All Training Done"


app = Flask(__name__)
cors = CORS(app)
app.config['CORS_HEADERS'] = 'Content-Type'


@app.route("/")
@cross_origin()
def run():
    global updated
    global rejected
    global num_rounds
    global_model = create_global_model()
    additional_info = {"learning_rate": 0.01}
    save_global_updates(global_model, additional_info)
    final_model = federated_training(global_model)
    return jsonify({"message": "OK"}), 200


@app.route("/get-logs")
@cross_origin()
def log():
    global logs
    data = {'value': '\n'.join(logs), 'code': 'SUCCESS'}
    return make_response(jsonify(data), 200)


@app.route("/response", methods=['POST'])
def resopnse():
    global updated
    global rejected
    global num_rounds
    global rounds_counter
    payload = request.get_json()
    payload = json.loads(payload["completeData"])
    print('sad', payload.keys())

    data = payload['data']
    string_data = payload['value']
    print(data["client_id"],'responded')
    logs.append(f"{data['client_id']} responded")
    
    updated[int(data["client_id"])] = 1

    print('payload size', len(payload['value']))
    if payload['value'] == 'None':
      rejected.append(int(data["client_id"]))
      print(data["client_id"],'rejected training')
      logs.append(f"{data['client_id']} rejected training")
    
    else:

      with io.open(f"client_{data['client_id']}_update.pkl", "wb") as file:
        # Write the string data as bytes to the file
        file.write(string_data.encode("latin1"))

    # Access the data part of the request
    print(data)  # Example: {'key1': 'value1', 'key2': 'value2'}
    if all(i == 1 for i in updated):
        client_update_files = [f"client_{client_id}_update.pkl" for client_id in range(
            0, 3) if client_id not in rejected]
        print('aggregating')
        logs.append('Aggregating Modle')
        aggregated_weights = aggregate_client_updates(client_update_files)
        print('Aggregation Done!')
        logs.append('Aggregation Done!')

      # Update the global model
        global_model = create_global_model()
        global_model.set_weights(aggregated_weights)
        additional_info = {"learning_rate": 0.01}
        save_global_updates(global_model, additional_info)
        rounds_counter = rounds_counter + 1
        if rounds_counter <= num_rounds:
            logs.append(f"-- Round {rounds_counter } --")
            with open('./global_update.pkl', 'rb') as file:
                loaded_data = pickle.load(file)
                url = 'http://host.docker.internal:9081/train'
                print(get_size_in_mb(str(pickle.dumps(loaded_data))))
                headers = {'Content-Type': ': application/json'}
                response = requests.post(url, json={'value':str(pickle.dumps(loaded_data),'latin1'),'data':{'client_id':0,'epochs':3}}, timeout=10) 
                if response.status_code == 200:
                    print("File successfully sent to API.")
                else:
                    print("Error occurred while sending file to API. Status code:", response.status_code)
        else:
            print('All Done!')
            logs.append('All Done!')
        updated = [0,0,0]
        rejected = []
    else:
      with open('./global_update.pkl', 'rb') as file:
        loaded_data = pickle.load(file)
        url = 'http://host.docker.internal:9081/train'
        print(get_size_in_mb(str(pickle.dumps(loaded_data))))
        headers = {'Content-Type': ': application/json'}
        response = requests.post(url, json={'value':str(pickle.dumps(loaded_data),'latin1'),'data':{'client_id':int(data["client_id"])+1,'epochs':3}}) 
        if response.status_code == 200:
            print("File successfully sent to API.")
        else:
            print("Error occurred while sending file to API. Status code:", response.status_code)
    return 'File and data received'+ '200'
   
if __name__ == "__main__":
    updated = [0, 0, 0]
    rejected = []
    logs = []
    num_rounds = 2
    rounds_counter = 1
    app.run(host='0.0.0.0', port=int("4500"), debug=True)
