import React, { useEffect } from 'react'
import { Box, Stack } from '@mui/system'
// import { useStateValue } from '../../state/state'
import { useNavigate } from 'react-router-dom'
import { Button, IconButton, Typography, useTheme } from "@mui/material";
// import cachePull from '../../utils/cachePull'


const Dashboard = () => {
    const theme = useTheme();
    const colors = theme.palette;
    // const [, dispatch] = useStateValue()
    const navigate = useNavigate()

    // useEffect(function () {
    //     const user = cachePull()
    //     if (user) {
    //         // dispatch({ type: "SET_USER", payload: user })
    //     } else {
    //         //navigate("/")
    //     }
    // }, [dispatch, navigate]);

    return (
      <Box sx = {{color: "F8F8F8"}}>
        <Typography variant="h3" sx={{ color: "#000000"}}>
          Dashboard
        </Typography>
        <Typography variant="h5" sx={{ padding: "20px 30px 0 5px", color: "#000000"}}>
          TODO cool insights here
        </Typography>
      </Box>
    );
}

export default Dashboard

            {/* <Box height="250px">
              <div style={{ paddingLeft:"50px", paddingRight:"10px", height:"300px", width:"300px"}}>
                  <Donut />
                </div>
            </Box> */}