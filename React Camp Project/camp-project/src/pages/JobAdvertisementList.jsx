import React, { useState, useEffect } from "react";
import { Icon, Menu, Table, Button, Item, Label } from 'semantic-ui-react'
import JobAdvertisementService from "../services/jobAdvertisementService";
import { Link } from "react-router-dom";


export default function JobAdvertisementList() {
    const [jobAdvertisements, setJobAdvertisements] = useState([]);

    useEffect(() => {
        let jobAdvertisementService = new JobAdvertisementService();
        jobAdvertisementService.getJobAdvertisement().then(result => setJobAdvertisements(result.data.data))
    }, [])


    return (
        <div>
            <div>
                <Table celled>
                    <Table.Header>

                        <Table.Row>

                            <Table.HeaderCell textAlign="center">Job Advertisement</Table.HeaderCell>


                        </Table.Row>
                    </Table.Header>

                    <Table.Body>{
                        jobAdvertisements.map(jobadv => (
                            <Item.Group divided>
                                <Item>
                                    <Item.Image src='https://st2.depositphotos.com/4328131/6387/v/600/depositphotos_63870593-stock-illustration-graphic-silver-b-letter-symbol.jpg' />

                                    <Item.Content>
                                        <Item.Header as='a'>{jobadv.employer.companyName}</Item.Header>
                                        <Item.Meta>
                                            <span className='cinema'>{jobadv.city.cityName}</span>
                                        </Item.Meta>
                                        <Item.Description>{jobadv.jobDescription}</Item.Description>
                                        <Item.Extra>
                                            <Label>{jobadv.lastApplyDate}</Label>
                                            <Label icon='globe' content={jobadv.job.position} />
                                            <Link to={"jobAdvertisement/" + jobadv.id}><Button primary floated='right' >
                                                See More Info
                                                <Icon name='right chevron' />
                                            </Button></Link>
                                        </Item.Extra>
                                    </Item.Content>
                                </Item>
                                <hr></hr>
                            </Item.Group>
                        ))

                    }

                    </Table.Body>

                    <Table.Footer>
                        <Table.Row>
                            <Table.HeaderCell colSpan='3'>
                            <Link to="/jobAdvertisement/add/n">
                                    <Button positive divided>Create new job advertisement</Button>
                                </Link>
                                <Menu floated='right' pagination>
                                    <Menu.Item as='a' icon>
                                        <Icon name='chevron left' />
                                    </Menu.Item>
                                    <Menu.Item as='a'>1</Menu.Item>
                                    <Menu.Item as='a'>2</Menu.Item>
                                    <Menu.Item as='a'>3</Menu.Item>
                                    <Menu.Item as='a'>4</Menu.Item>
                                    <Menu.Item as='a' icon>
                                        <Icon name='chevron right' />
                                    </Menu.Item>
                                </Menu>
                            </Table.HeaderCell>
                        </Table.Row>
                    </Table.Footer>
                </Table>
            </div>

        </div>
    )
}
