import React, { useEffect, useState } from 'react'
import { Box, Stack } from '@mui/system'
// import { useStateValue } from '../../state/state'
import { useNavigate } from 'react-router-dom'
import { Button, IconButton, Typography, useTheme } from "@mui/material";
// import cachePull from '../../utils/cachePull'


const ComputationPage = () => {
    const theme = useTheme();
    const [log, setLog] = useState("");
    const colors = theme.palette;
    // const [, dispatch] = useStateValue()
    const navigate = useNavigate()
    const handleTrainingButtonClick = () => {
      console.log('Training button clicked');
      //var url = 'http://host.docker.internal:9081/compute'

      var url = 'http://localhost:9081/compute'

      fetch(url, {
        method: 'GET',
        mode: 'cors',
        headers: {
          'Content-Type': 'application/json'
        }
      })
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        console.log('Response:', response.text());
      })
      .then(data => {
        console.log('Success:', data);
      })
      .catch(error => {
        console.error('Error:', error);
      });
    };
  
    const handleRefreshStatusButtonClick = async () => {
      //var url = 'http://host.docker.internal:9081/get-logs'
      var url = 'http://localhost:9081/get-logs'

      let data = await fetch(url, {
        method: 'GET',
        mode: 'cors',
        headers: {
          'Content-Type': 'application/json'
        }
      }).then(response => {
        return response.json(); // This returns a Promise
      })
      const jsonString = JSON.stringify(data, null, 4); // Use 4 spaces for indentation
      const multiLineString = jsonString.replace(/(?:\\[rn]|[\r\n]+)+/g, '\n');
      console.log(multiLineString)
      setLog(multiLineString)
    };
    return (
      <Box sx = {{color: "F8F8F8"}}>
        <Typography variant="h3" sx={{ color: "#000000"}}>
          Computation: 
        </Typography>
        <Typography variant="h5" sx={{ padding: "20px 30px 0 5px", color: "#000000"}}>
        <div>
          <button onClick={handleTrainingButtonClick}>Compute</button>
          <button onClick={handleRefreshStatusButtonClick}>Refresh Status</button>
          <p>Computation Logs: </p>
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

export default ComputationPage

            {/* <Box height="250px">
              <div style={{ paddingLeft:"50px", paddingRight:"10px", height:"300px", width:"300px"}}>
                  <Donut />
                </div>
            </Box> */}