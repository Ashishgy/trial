import { useEffect, useState, useRef } from 'react'
import { Box, Stack } from '@mui/system'
// import { useStateValue } from '../../state/state'
import { useNavigate } from 'react-router-dom'
import { Button, IconButton, Typography, useTheme } from "@mui/material";
import SectionCard from '../../components/SectionCard';
import DataMenu from '../../components/DataMenu';
import config from '../../utils/config'
import axios from 'axios'
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


const SettingsPage = () => {
    const [dataMenuSelection, setDataMenuSelection] = useState({});
    
    async function updateDataMenuSelection() {
      const response = await axios.get(`${config.BACKEND_BASE_URL}/data-menu-settings`);
      console.log("fetched data menu:", response.data);
      setDataMenuSelection(response.data);
    }

    async function cancelChanges(){
      await updateDataMenuSelection();
      toast.info("Reverted Changes");
    }

    async function saveDataMenuSelection() {
      const response = await axios.put(`${config.BACKEND_BASE_URL}/data-menu-settings`, dataMenuSelection);
      toast.success("Saved Data Settings");
    }

    const hasRan = useRef(false);
    useEffect(() => {
      if (!hasRan.current){
        hasRan.current = true;

        updateDataMenuSelection();
      }
    }, []);



    return (
      <SectionCard>
        <Typography variant="h3" sx={{ color: "#000000"}}>
          Data Pulling
        </Typography>

        <DataMenu dataMenuSelection={dataMenuSelection} setDataMenuSelection={setDataMenuSelection}></DataMenu>

        <Box>
          <Button
            sx={{ display: "flex", justifyContent: "center", alignItems: "center" }}
            variant="contained"
            onClick={saveDataMenuSelection}>
              Save Changes
          </Button>
          <Button
            sx={{ display: "flex", justifyContent: "center", alignItems: "center" }}
            variant="contained"
            onClick={cancelChanges}>
              Cancel Changes
          </Button>
        </Box>

        <ToastContainer />
      </SectionCard>
    );
}

export default SettingsPage
