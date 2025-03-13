import React, { useState, useEffect, useRef  } from 'react'
import { Box, Stack } from '@mui/system'
// import { useStateValue } from '../../state/state'
import { useNavigate } from 'react-router-dom'
import { TextField , Backdrop, Fade, Modal, Card, CardContent, Button, IconButton, Typography, useTheme } from "@mui/material";
// import cachePull from '../../utils/cachePull'
import { NavLink } from "react-router-dom";
import config from '../../utils/config'
import axios from 'axios'
import { styled } from '@mui/system';
import MyModal from '../../components/MyModal';
import MyModalContent from '../../components/MyModalContent';
import MyCard from '../../components/MyCard';
import InvitationDetailModal from './InvitationDetailModal';
import SectionCard from '../../components/SectionCard';
import { DataGrid } from "@mui/x-data-grid";
import ParticipationDetailModal from './ParticipantDetailModal';


const ParticipantsPage = () => {
    const theme = useTheme();
    const colors = theme.palette;
    // const [, dispatch] = useStateValue()
    // const navigate = useNavigate()

    const [invitations, setInvitations] = useState({});
    const [participants, setParticipants] = useState([]);

    const [newInvitationFormOpen, setNewInvitationFormOpen] = useState(false);
    const [newInvitationFormData, setNewInvitationFormData] = useState({name: ""});

    const [invitationModalOpen, setInvitationModalOpen] = useState(false);
    const [detailData, setDetailData] = useState({});

    const [participantModalOpen, setParticipantModalOpen] = useState(false);
    const [participantDetailData, setParticipantDetailData] = useState({});


    async function updateInvitationsList() {
      const invitationsResponse = await axios.get(`${config.BACKEND_BASE_URL}/invitations`);
      console.log("fetched invitations list:", invitationsResponse.data);

      const invitationsMap = {};
      for (const invitation of invitationsResponse.data){
        const invitationKey = invitation.invitationKey ? invitation.invitationKey : "[not tracked]";
        invitationsMap[invitationKey] = invitation;
      }
      setInvitations(invitationsMap);


      const participantsResponse = await axios.get(`${config.BACKEND_BASE_URL}/participants`);
      console.log("fetched participants list:", participantsResponse.data);
      const participantsNew = participantsResponse.data;
      for (var i = 0; i < participantsNew.length; i++){
        const participant = participantsNew[i];
        participant.number = i + 1;
      }
      setParticipants(participantsResponse.data);
    }

    
    const handleInputChange = (e) => {
      const { name, value } = e.target;
      setNewInvitationFormData({
        ...newInvitationFormData,
        [name]: value,
      });
    };

    const handleSubmit = async () => {
      const response = await axios.post(`${config.BACKEND_BASE_URL}/invitations`, newInvitationFormData);

      // Close the modal
      setNewInvitationFormOpen(false);

      var newInvitation = response.data;
      setDetailData(newInvitation);
      setInvitationModalOpen(true);

      updateInvitationsList();
    };

    const hasRan = useRef(false);
    useEffect(() => {
      if (!hasRan.current){
        hasRan.current = true;

        updateInvitationsList();
      }
  
      document.title = 'Connections';
      return () => {
        document.title = 'TODO title';
      };
    }, []);



    function epochSecondsToDateTimeString(epochSeconds) {
      return new Date(epochSeconds * 1000).toLocaleString();
    }


    const columns = [  
      { field: 'id', headerName: 'ID' },  
      { field: 'createdAtStr', headerName: 'Join Date Time', flex: 1 },
      { field: 'invitationName', headerName: 'Invitation Used', flex: 1 },  
      ];
  
    const rows = participants.map((participant, idx) => {
      const invitation = invitations[participant.invitationKey];
      const invitationName = invitation ? invitation.name : "[unknown invitation]";
      const r = {
        ...participant,
        id: participant._id.substring(0, 8),
        createdAtStr: epochSecondsToDateTimeString(participant.createdAt),
        invitationName: invitationName,
      };
      console.log(r);
      return r;
    });

    // <div style={{ display: 'flex', flexWrap: 'wrap', flexDirection: 'column' }}>
    //         {participants.map(item => {
    //           return (
    //             <MyCard key={item._id} onClick={() => { setDetailData(item); setDetailModalOpen(true) }} style={{cursor: 'pointer'}}>
    //               <CardContent>
    //                 {/* TODO click to bringup detail modal - then theres a list of toggles for each requested permission (which the serv prov provides/responds again from the first/initial connection message). Delete button here. */}
    //                 <Typography component="div">
    //                   {item.name} - {item.createdAt}
    //                 </Typography>
    //               </CardContent>
    //             </MyCard>
    //           );
    //         })}
    //       </div>
    return (
      <div>
        <SectionCard>
          <Typography variant="h3" sx={{ color: "#000000"}}>
            Connected Participants
          </Typography>
          {/* TODO refresh button here */}

          <Box sx={{ height: 300, width: '100%', maxWidth: 800 }}>
            <DataGrid  
            rows={rows} 
            columns={columns}
            onRowClick={(p) => { setParticipantDetailData(p.row); setParticipantModalOpen(true); }}
            disableSelectionOnClick
            rowSelectionModel={[]} 
             />
          </Box>

          <ParticipationDetailModal isOpen={participantModalOpen} onClose={() => setParticipantModalOpen(false)} detailData={participantDetailData} onListingUpdate={updateInvitationsList} />
        </SectionCard>



        <SectionCard>
          <Typography variant="h3" sx={{ color: "#000000"}}>
            Connection Invitations
          </Typography>

          <div style={{ display: 'flex', flexWrap: 'wrap', flexDirection: 'column' }}>
            {Object.entries(invitations).map(([key, item]) => {
              return (
                <MyCard key={key} onClick={() => { setDetailData(item); setInvitationModalOpen(true) }} style={{cursor: 'pointer'}}>
                  <CardContent>
                    {/* TODO click to bringup detail modal - then theres a list of toggles for each requested permission (which the serv prov provides/responds again from the first/initial connection message). Delete button here. */}
                    <Typography component="div">
                      {item.name} <i>(created {epochSecondsToDateTimeString(item.createdAt)})</i>
                    </Typography>
                  </CardContent>
                </MyCard>
              );
            })}
          </div>

          <Button
            sx={{ display: "flex", justifyContent: "center", alignItems: "center" }}
            variant="contained"
            onClick={() => setNewInvitationFormOpen(true)}>
              Create Invitation
          </Button>


          <MyModal
            open={newInvitationFormOpen}
            onClose={() => setNewInvitationFormOpen(false)}
            closeAfterTransition
          >
            <Fade in={newInvitationFormOpen}>
              <MyModalContent>
                <h2>Make a Connection Invitation</h2>
                
                <TextField
                  label="Invitation Name (for internal record keeping)"
                  name="name"
                  value={newInvitationFormData.name}
                  onChange={handleInputChange}
                  fullWidth
                  autoComplete="off"
                  margin="normal"
                />

                <Button variant="contained" onClick={handleSubmit}>
                  Create
                </Button>
                <Button variant="contained" onClick={() => setNewInvitationFormOpen(false)} color="secondary">
                  Cancel
                </Button>
              </MyModalContent>
            </Fade>
          </MyModal>

          <InvitationDetailModal isOpen={invitationModalOpen} onClose={() => setInvitationModalOpen(false)} detailData={detailData} onListingUpdate={updateInvitationsList} />

        </SectionCard>
      </div>
    );
}

export default ParticipantsPage
