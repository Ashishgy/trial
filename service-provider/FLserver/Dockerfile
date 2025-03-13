FROM python:3.9.6


# Set the working directory
WORKDIR /app


COPY requirements.txt .
RUN pip install --upgrade pip
RUN pip install setuptools
RUN pip install requests
RUN apt-get update && apt-get install -y libhdf5-dev
RUN pip install --no-binary h5py h5py
RUN pip install -r requirements.txt
RUN pip install scipy
RUN pip install keras-layer-normalization


COPY . .


# Start the application
CMD ["python", "-u","app.py"]