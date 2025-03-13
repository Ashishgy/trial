import React, { useEffect, useState } from 'react'
import { Box, Stack } from '@mui/system'
// import { useStateValue } from '../../state/state'
import { useNavigate } from 'react-router-dom'
import { Button, IconButton, Typography, useTheme } from "@mui/material";
// import cachePull from '../../utils/cachePull'


const TrainingPage = () => {
    const theme = useTheme();
    const [log, setLog] = useState("");
    const colors = theme.palette;
    // const [, dispatch] = useStateValue()
    const navigate = useNavigate()
    const handleTrainingButtonClick = () => {
      console.log('Training button clicked');
      //var url = 'http://host.docker.internal:4500/'
      var url = 'http://localhost:4500/'

      fetch(url, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json'
        }
      })
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        console.log('Response:', response.json());
      })
      .then(data => {
        console.log('Success:', data);
      })
      .catch(error => {
        console.error('Error:', error);
      });
    };
  
    const handleRefreshStatusButtonClick = async () => {
      //var url = 'http://host.docker.internal:4500/get-logs'
      var url = 'http://localhost:4500/get-logs'
      try {
        const response = await fetch(url, {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json'
          }
        });
        const data = await response.json();
        console.log(data);
        setLog(data['value']);
      } catch (error) {
        console.error('Error:', error);
        setLog('Error fetching logs');
      }
    };
    return (
      <Box sx = {{color: "F8F8F8"}}>
        <Typography variant="h3" sx={{ color: "#000000"}}>
          Model Training: 
        </Typography>
        <Typography variant="h5" sx={{ padding: "20px 30px 0 5px", color: "#000000"}}>
        <div>
          <button onClick={handleTrainingButtonClick}>Training</button>
          <button onClick={handleRefreshStatusButtonClick}>Refresh Status</button>
          <p>Traning Logs: </p>
          <div>
              {log.split("\n").map((i,key) => {
                  return <div key={key}>{i}</div>;
              })}
          </div>
        </div>
        </Typography>
      </Box>
    );
}

export default TrainingPage