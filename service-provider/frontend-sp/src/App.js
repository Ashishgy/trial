import { Routes, Route, useNavigate,  Navigate } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { jwtDecode } from "jwt-decode";
import './App.css';
// import Dashboard from './scenes/dashboard/index';
import Dashboard from './scenes/dashboard';

import PageFrame from './components/PageFrame';
import { CssBaseline, ThemeProvider,Box } from '@mui/material';
import {theme} from "./theme";
import Profile from './scenes/profile';
import ParticipantsPage from './scenes/participants';
import SettingsPage from './scenes/settings';
import HelpPage from './scenes/help';
import TrainingPage from './scenes/training';
import ComputationPage from './scenes/compute';
import Login from './scenes/login';
import SignUp from './scenes/login/signup';

// Protected Route Component
const ProtectedRoute = ({ children }) => {
  const navigate = useNavigate();
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const verifyToken = () => {
      const token = localStorage.getItem("jwt_token_service");
      
      if (!token) {
        setIsAuthenticated(false);
        setIsLoading(false);
        return;
      }

      try {
        const decoded = jwtDecode(token);
        const currentTime = Date.now() / 1000;

        if (decoded.exp < currentTime) {
          console.warn("Token expired. Logging out...");
          localStorage.removeItem("jwt_token_service");
          setIsAuthenticated(false);
        } else {
          setIsAuthenticated(true);
        }
      } catch (error) {
        console.error("Token verification failed:", error);
        localStorage.removeItem("jwt_token_service");
        setIsAuthenticated(false);
      }
      
      setIsLoading(false);
    };

    verifyToken();
  }, [navigate]);

  if (isLoading) {
    return <div>Loading...</div>;
  }

  return isAuthenticated ? children : <Navigate to="/login" />;
};

function App() {
  return (
    <div style={{ height: "100vh" }}>
      <ThemeProvider theme={theme}>
        <CssBaseline />


        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<SignUp />} />

          <Route path="/" element={ <ProtectedRoute><PageFrame element={<Dashboard/>}/></ProtectedRoute>} />
          <Route path="/profile" element={ <ProtectedRoute><PageFrame element={<Profile/>}/></ProtectedRoute>} />
          <Route path="/participants" element={ <ProtectedRoute><PageFrame element={<ParticipantsPage/>}/></ProtectedRoute>} />
          <Route path="/settings" element={ <ProtectedRoute><PageFrame element={<SettingsPage/>}/></ProtectedRoute>} />
          <Route path="/training" element={ <ProtectedRoute><PageFrame element={<TrainingPage/>}/></ProtectedRoute>} />
          <Route path="/compute" element={ <ProtectedRoute><PageFrame element={<ComputationPage/>}/></ProtectedRoute>} />
          <Route path="/about" element={ <ProtectedRoute><PageFrame element={<HelpPage/>}/></ProtectedRoute>} />
          {/* <Route path="/connections" element={<ConnectionsPage/>} /> */}

          <Route path="*" element={<Navigate to="/login" replace />} />

        </Routes>
      </ThemeProvider>
    </div>

  );
}

export default App;
