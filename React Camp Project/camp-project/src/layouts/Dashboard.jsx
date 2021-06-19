import React from 'react'
import Categories from './Categories'
import { Grid } from "semantic-ui-react";
import JobList from "../pages/JobList"
import { Route } from 'react-router';
import JobAdvertisementList from '../pages/JobAdvertisementList';
import JobAdvertisementDetails from '../pages/JobAdvertisementDetails';
import JobAdvertisementAdd from '../pages/JobAdvertisementAdd';
import JobAdvertisementActivate from '../pages/JobAdvertisementActivate';




export default function Dashboard() {
    return (
        <div>
            <Grid>
                <Grid.Row>
                    <Grid.Column width={4}>
                        <Categories/>
                    </Grid.Column>
                    <Grid.Column width={12}>
                        <Route exact path="/jobAdvertisement" component ={JobAdvertisementList}></Route>
                        <Route exact path="/jobList" component = {JobList}></Route>
                        <Route exact path="/jobAdvertisement/:id" component ={JobAdvertisementDetails}></Route>
                        <Route exact path="/jobAdvertisement/add/n" component ={JobAdvertisementAdd}></Route>
                        <Route exact path="/activateJobAdvertisement" component ={JobAdvertisementActivate}></Route>

                    </Grid.Column>
                </Grid.Row>
            </Grid>
        </div>
    )
}
