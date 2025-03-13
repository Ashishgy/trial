import { useState, useEffect } from "react";
import { Sidebar, Menu, MenuItem} from "react-pro-sidebar";
import { Box, IconButton, Typography, useTheme } from "@mui/material";
import { NavLink } from "react-router-dom";
// import { tokens } from "../theme";
// import 'react-pro-sidebar/dist/css/styles.css';
import MenuOutlinedIcon from "@mui/icons-material/MenuOutlined";
import HomeOutlinedIcon from "@mui/icons-material/HomeOutlined";
import PersonIcon from '@mui/icons-material/Person';
import PersonOutlinedIcon from '@mui/icons-material/PersonOutlined';
import PeopleOutlinedIcon from "@mui/icons-material/PeopleOutlined";
import LanguageIcon from '@mui/icons-material/Language';
import LogoutOutlinedIcon from '@mui/icons-material/LogoutOutlined';
import SettingsOutlinedIcon from '@mui/icons-material/SettingsOutlined';
import TrendingUpOutlinedIcon from '@mui/icons-material/TrendingUpOutlined';
import CalendarMonthOutlinedIcon from '@mui/icons-material/CalendarMonthOutlined';
import ChatBubbleOutlineOutlinedIcon from '@mui/icons-material/ChatBubbleOutlineOutlined';
import LocalFloristOutlinedIcon from '@mui/icons-material/LocalFloristOutlined';
import QuestionMarkOutlinedIcon from '@mui/icons-material/QuestionMarkOutlined';
import DataObjectOutlinedIcon from '@mui/icons-material/DataObjectOutlined';

// import StressScore from "../StressScore";
// import Logout from "../../components/Logout";


const SidebarHeader = () => {
  return (
    <Typography sx={{ textAlign: 'center', marginBottom: '1rem' }} variant="h4" fontWeight={800} color="orange" >
      Service Provider
    </Typography>
  );
};

const Item = ({ title, to, icon, selected, setSelected }) => {
  // const theme = useTheme();
  // const colors = tokens(theme.palette.mode);
  // const activeStyle = {
  //   color: 'blue',
  //   // Add other styles as needed
  // };

  return (
    <MenuItem
      active={selected === title}
      onClick={() => setSelected(title)}
      icon={icon}
      component={
      <NavLink to={to} />
    }
    >
      <Typography>{title}</Typography>
    </MenuItem>
  );
};

// const Item2=()=>{
//     return(
//         <MenuItem disabled={true} background= {'$(colors.primary)'}></MenuItem>
//     )
// };

const ThisProSidebar = () => {
  // const theme = useTheme();
  // const colors = tokens(theme.palette.mode);
  const [isCollapsed, setIsCollapsed] = useState(false);
  const [selected, setSelected] = useState("Dashboard");

  useEffect(() => {
    // Your side effect code goes here
    console.log('Component did mount or update');

    // Cleanup function (optional)
    return () => {
      console.log('Component will unmount or before next update');
      // Perform cleanup here, such as clearing intervals or canceling network requests
    };
  }, []); // Dependency array (optional)

  return (
    // https://github.com/azouaoui-med/react-pro-sidebar#readme
    <Sidebar collapsed={isCollapsed} >
      <SidebarHeader/>
      <Menu iconShape="square" menuItemStyles={{
      button: {
        // the active class will be added automatically by react router
        // so we can use it to style the active menu item
        [`&.active`]: {
          backgroundColor: '#003071',
          color: '#b6c8d9',
        },
      },
    }}>
        <Box paddingLeft={isCollapsed ? undefined : "10%"}>
          <Item 
              title= {"Dashboard"}
              to="../"
              icon = {<HomeOutlinedIcon />}
              selected= {selected}
              setSelected= {setSelected} 
          />
          <Item
              title={"Collected Data"}
              to="../profile"
              icon ={<DataObjectOutlinedIcon />}
              selected={selected}
              setSelected={setSelected}
          />
          <Item 
              title={"Participants"}
              to="/participants"
              icon ={<PeopleOutlinedIcon />}
              selected={selected}
              setSelected={setSelected}
          />
          <Item 
              title={"Settings"}
              to="/settings"
              icon ={<SettingsOutlinedIcon />}
              selected={selected}
              setSelected={setSelected}
          />
          <Item 
              title={"Training"}
              to="/training"
              icon ={<LocalFloristOutlinedIcon />}
              selected={selected}
              setSelected={setSelected}
          />
          <Item 
              title={"Computation"}
              to="/compute"
              icon ={<LocalFloristOutlinedIcon />}
              selected={selected}
              setSelected={setSelected}
          />
          <Item 
              title={"Help / About"}
              to="/about"
              // TODO do rounded question mark icon instead, like maybe with a circle around it.
              icon ={<QuestionMarkOutlinedIcon />} 
              selected={selected}
              setSelected={setSelected}
          />
        </Box>
      </Menu>
    </Sidebar>
  );
};

export default ThisProSidebar;