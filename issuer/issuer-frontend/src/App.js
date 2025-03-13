import logo from './logo.svg';
import { useState, useEffect, useRef  } from 'react'
import './App.css';
import axios from 'axios'
import { TextField , Backdrop, Fade, Modal, Card, CardContent, Button, IconButton, Typography, useTheme, Box } from "@mui/material";
import config from './config'

function App() {

  const [emailAddress, setEmailAddress] = useState("");

  const [credentialUrl, setCredentialUrl] = useState("");


  const handleInputChange = (e) => {
    setEmailAddress(e.target.value);
  };

  const handleSubmit = async () => {
    const response = await axios.post(`${config.BACKEND_BASE_URL}/send-email`, {email: emailAddress});
  };

  async function fetchCredential(code){
    const response = await axios.post(`${config.BACKEND_BASE_URL}/verify/${code}`);
    setCredentialUrl(response.data);
  }

  const params = new URLSearchParams(window.location.search);
  const code = params.get('verify_code');

  const hasRan = useRef(false);
  useEffect(() => {
    if (!hasRan.current){
      hasRan.current = true;

      if (code){
        fetchCredential(code);
      }
    }
  }, []);

  return (
    <div>
      <Box
      sx={{
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        height: '80vh',
      }}
    >
       <Box>
        {code ? (
          <div>
            <p>Add your credential:</p>
            <textarea rows={4} style={{width:"500px"}} value={credentialUrl} readOnly />
          </div>
        ) : (
          <div>
          <p>Verify your email to receive a credential:</p>
          <TextField
              label="Email Address"
              value={emailAddress}
              onChange={handleInputChange}
              fullWidth
              autoComplete="off"
              margin="normal"
            />
          <Button onClick={handleSubmit}>Send Verification Email</Button>

        </div>
        )}
        </Box>
    </Box>
    </div>
  );
}

export default App;
