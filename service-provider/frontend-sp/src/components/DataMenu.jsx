import React from 'react';
import ThisProSidebar from './SideBar.jsx';
import { useState, useEffect } from "react";
import { Box } from '@mui/system'
import { FormLabel, Select, MenuItem, Typography } from '@mui/material';
import FormControl from '@mui/material/FormControl';
import FormGroup from '@mui/material/FormGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import Switch from '@mui/material/Switch';


const DataMenu = ({dataMenuSelection, setDataMenuSelection}) => {
  console.log("data menu:", dataMenuSelection);
  return (
    <Box sx={{paddingBottom: "20px"}}>
      
      {Object.entries(dataMenuSelection).map(([dataSourceKey, dataSourceValue]) => (
        <div key={dataSourceKey}>
          <Typography variant="h6">{dataSourceValue.name}</Typography>
          <FormGroup>
            {Object.entries(dataSourceValue.items).map(([dataItemKey, dataItemValue]) => (
              <DataItem key={dataItemKey} title={dataItemValue.name} dataMenuSelection={dataMenuSelection} setDataMenuSelection={setDataMenuSelection} dataSourceKey={dataSourceKey} dataItemKey={dataItemKey}></DataItem>
            ))}
          </FormGroup>
        </div>
      ))}
      

      {/* <Typography variant="h6" paddingTop="20px">Google Maps</Typography>
      <FormGroup>
        <DataItem dataKey="spotify:fav-artist" title="Zip Code"></DataItem>
      </FormGroup> */}
    </Box>
  );
};

const DataItem = ({title, dataMenuSelection, setDataMenuSelection, dataSourceKey, dataItemKey}) => {
  const handleSwitchChange = (isSwitchOn) => {
    setDataMenuSelection((prevData) => {
      const newData = {
        ...prevData,
      };
      newData[dataSourceKey]["items"][dataItemKey]["selected"] = isSwitchOn;
      return newData;
    });
  };

  return (
    <FormControl component="fieldset" variant="standard">
      <Box>
        <FormControlLabel control={
          <Switch 
          checked={dataMenuSelection[dataSourceKey]["items"][dataItemKey]["selected"] || false} // Set to false if undefined, which may happen if "selected" attr doesn't exist (yet).
          onChange={(event) => handleSwitchChange(event.target.checked)} 
          />
        } label={title} />
        <Select
          labelId="demo-simple-select-label"
          value={1}
          label="Age"
          // onChange={handleChange}
        >
          <MenuItem value={1}>Once</MenuItem>
          <MenuItem value={2}>Daily</MenuItem>
          <MenuItem value={2}>Weekly</MenuItem>
          <MenuItem value={3}>Monthly</MenuItem>
        </Select>
      </Box>
    </FormControl>
  );
};

export default DataMenu;
