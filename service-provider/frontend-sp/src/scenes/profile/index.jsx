import { useState, useEffect, useRef  } from 'react'
import { Box, Stack } from '@mui/system'
// import { useStateValue } from '../../state/state'
import { useNavigate } from 'react-router-dom'
import { Button, IconButton, Typography, useTheme } from "@mui/material";
import MyModal from '../../components/MyModal';
import MyModalContent from '../../components/MyModalContent';
import MyCard from '../../components/MyCard';
import SectionCard from '../../components/SectionCard';
import { DataGrid } from "@mui/x-data-grid";
import axios from 'axios'
import config from '../../utils/config'
// import cachePull from '../../utils/cachePull'


const Profile = () => {
    const theme = useTheme();

    const [data, setData] = useState([]);

    async function updateCollectedDataList() {
      const response = await axios.get(`${config.BACKEND_BASE_URL}/collected-data`);
      console.log("fetched data:", response.data);
      setData(response.data);
    }

    function downloadJSONAsFile(jsonData, filename) {
      const jsonBlob = new Blob([JSON.stringify(jsonData, null, 2)], { type: 'application/json' });
      const url = URL.createObjectURL(jsonBlob);
      
      const link = document.createElement('a');
      link.href = url;
      link.download = filename;
      
      document.body.appendChild(link);
      link.click();
      
      document.body.removeChild(link);
      URL.revokeObjectURL(url);
  }

    async function download() {
      downloadJSONAsFile(data, "sp-data.json");
    }

    const hasRan = useRef(false);
    useEffect(() => {
      if (!hasRan.current){
        hasRan.current = true;

        updateCollectedDataList();
      }
    }, []);


    function epochSecondsToDateTimeString(epochSeconds) {
      return new Date(epochSeconds * 1000).toLocaleString();
    }

    const columns = [  
      { field: 'datetime', headerName: 'Date Time', flex: 1 },
      { field: 'userId', headerName: 'Participant ID', flex: 1 },
      { field: 'dataSourceId', headerName: 'Data Source', flex: 1 },
      { field: 'dataItemId', headerName: 'Data Item', flex: 1 },
      { field: 'dataStr', headerName: 'Data', flex: 2 },  
      ];
  
    const rows = data.map((dataItem, idx) => {
      const r = {
        ...dataItem,
        datetime: epochSecondsToDateTimeString(dataItem.epoch_seconds),
        userId: dataItem.participantId.substring(0, 8),
        dataStr: JSON.stringify(dataItem.data, null, 2),
        id: dataItem._id,
      };
      console.log(r);
      return r;
    });


    return (
      <SectionCard>
        <Typography variant="h3" sx={{ color: "#000000"}}>
          Collected Data
        </Typography>

        <Box sx={{ height: '500px', width: '800px', maxWidth: 1500 }}>
          <DataGrid 
          rows={rows} 
          columns={columns}
          disableSelectionOnClick
          rowSelectionModel={[]} 
            />
        </Box>

        <Button variant="contained" onClick={download}>
          Download Data Dump
        </Button>
        
      </SectionCard>
    );
}

export default Profile
