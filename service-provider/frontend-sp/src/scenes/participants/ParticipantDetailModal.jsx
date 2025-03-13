import { styled } from '@mui/system';
import { TextField , Backdrop, Fade, Modal, Card, CardContent, Button, IconButton, Typography, useTheme, Box } from "@mui/material";
import axios from 'axios'
import MyModal from '../../components/MyModal';
import MyModalContent from '../../components/MyModalContent';
import config from '../../utils/config'

const ParticipationDetailModal = ({ isOpen, onClose, detailData, onListingUpdate }) => {
  console.log("detail modal", detailData);

  const deleteItem = async () => {
    var response = await axios.delete(`${config.BACKEND_BASE_URL}/participants/${detailData._id}`);
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

  function epochSecondsToDateTimeString(epochSeconds) {
    return new Date(epochSeconds * 1000).toLocaleString();
  }

  return (
    <MyModal
    open={isOpen}
    onClose={onClose}
    closeAfterTransition
    >
    <Fade in={isOpen}>
      <MyModalContent>
        <h2>Participant #{detailData.number}</h2>
        <Box style={containerStyle}>
          <Typography style={style}>
            <strong>Join Date:</strong> {epochSecondsToDateTimeString(detailData.createdAt)}
          </Typography>
          <Typography style={style}>
          <strong>Invitation used to Join:</strong> {detailData.invitationName}
          </Typography>
        </Box>
        <Box style={{padding: "10px"}}>
          <Button variant="contained" onClick={deleteItem}>
            Remove & Block
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

export default ParticipationDetailModal
