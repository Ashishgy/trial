import React, { useEffect } from 'react'
import { Box, Stack } from '@mui/system'
// import { useStateValue } from '../../state/state'
import { useNavigate } from 'react-router-dom'
import { Button, IconButton, Typography, useTheme } from "@mui/material";
import SectionCard from '../../components/SectionCard';
import DataMenu from '../../components/DataMenu';
// import cachePull from '../../utils/cachePull'


const HelpPage = () => {
    const theme = useTheme();
    const colors = theme.palette;
    // const [, dispatch] = useStateValue()

    return (
      <SectionCard>
        <Typography variant="h3" sx={{ color: "#000000"}}>
          Help / About
        </Typography>
        <Typography variant="h5" sx={{ padding: "20px 30px 0 5px", color: "#000000"}}>
        TODO help page - explain the different tabs and how stuff works. Could have question mark icons that show beside the title on each page, and clicking on them could link you to the specific respective header for help for that page here - or maybe just a help modal that keeps you on that page would be better, idk.
        </Typography>
      </SectionCard>
    );
}

export default HelpPage
