import React from 'react'
import { Grid } from "semantic-ui-react";
import JobList from '../pages/JobList';
import CandidatesList from '../pages/CandidatesList';
import EmployersList from '../pages/EmployersList';
import Sidebar from './SideBar';

export default function Dashboard() {
    return (
        <div>
            <Grid>
                <Grid.Row>
                    <Grid.Column width={3}>
                        <Sidebar/>
                    </Grid.Column>
                    <Grid.Column width={13}>
                        <JobList />
                        <CandidatesList />
                        <EmployersList />
                    </Grid.Column>
                </Grid.Row>               
            </Grid>
        </div>
    )
}
