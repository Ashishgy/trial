import React from 'react';
import { useNavigate } from 'react-router-dom';
import ThisProSidebar from './SideBar.jsx';
import { useState, useEffect } from "react";
import { Box, Button } from '@mui/material';
import { ToastContainer } from 'react-toastify';

// Frames page with sidebar on the side of the actual content.
const PageFrame = ({ element }) => {
  const navigate = useNavigate();

  document.title = 'Serv Prov Agent';
  const handleLogout = () => {
    localStorage.removeItem("jwt_token_service"); // Clear token
    navigate("/login"); // Redirect to login
  };

  return (
    <div style={({ height: "100vh", display: "flex" })}>
      <ThisProSidebar/>
      <main>
      <Box m="5vh">
          <Button variant="outlined" color="secondary" onClick={handleLogout}>
            Logout
          </Button>
          {element}
          <ToastContainer />
        </Box>
      </main>
      
      {/* <ToastContainer /> */}
    </div>
  );
};

export default PageFrame;