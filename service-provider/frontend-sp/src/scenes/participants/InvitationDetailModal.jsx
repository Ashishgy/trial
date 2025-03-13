import { styled } from '@mui/system';
import { TextField , Backdrop, Fade, Modal, Card, CardContent, Button, IconButton, Typography, useTheme, Box } from "@mui/material";
import axios from 'axios'
import MyModal from '../../components/MyModal';
import MyModalContent from '../../components/MyModalContent';
import config from '../../utils/config'

const InvitationDetailModal = ({ isOpen, onClose, detailData, onListingUpdate }) => {
  console.log("detail modal", detailData);

  const deleteInvitation = async () => {
    var response = await axios.delete(`${config.BACKEND_BASE_URL}/invitations/${detailData._id}`);
    onListingUpdate();
    onClose();
  }

  const containerStyle = {
    maxWidth: '500px', // Set the maximum width to 'sm' (small)
    backgroundColor: 'white', // Customize the background color if needed
  };

  const style = {
    wordWrap: 'break-word', // This will make the URL wrap within the container
    overflow: 'hidden',     // This will hide any overflow content
  };

  return (
    <MyModal
    open={isOpen}
    onClose={onClose}
    closeAfterTransition
    >
    <Fade in={isOpen}>
      <MyModalContent>
        <h2>Connection Invitation</h2>
        <Box style={containerStyle}>
          <Typography variant="contained" style={style}>
            {detailData.url}
          </Typography>
        </Box>
        <Box style={{padding: "10px"}}>
          <Button variant="contained" onClick={deleteInvitation}>
            Delete
          </Button>
          <Button variant="contained" onClick={onClose} color="secondary">
          Close
          </Button>
        </Box>
      </MyModalContent>
    </Fade>
  </MyModal>
  )
};

export default InvitationDetailModal
