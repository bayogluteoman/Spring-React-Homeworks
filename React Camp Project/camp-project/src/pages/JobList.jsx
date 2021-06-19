import React, { useState,useEffect } from 'react';
import JobService from '../services/jobService';
import { Icon, Menu, Table } from 'semantic-ui-react'


export default function JobList() {
    const [Jobs, setJobs] = useState([])

    useEffect(() => {
        let jobService = new JobService();
        jobService.getJob().then(result => setJobs(result.data.data))
    })
    return (
        <div>
            <div>
                <Table celled>
                    <Table.Header>
                        <Table.Row>
                            <Table.HeaderCell>Job Name</Table.HeaderCell>
                            <Table.HeaderCell>Job Position</Table.HeaderCell>
                        </Table.Row>
                    </Table.Header>

                    <Table.Body>{
                        Jobs.map(job => (
                            <Table.Row key={job.id}>
                                <Table.Cell>{job.name}</Table.Cell>
                                <Table.Cell>{job.position}</Table.Cell>

                            </Table.Row>
                        ))

                    }

                    </Table.Body>

                    <Table.Footer>
                        <Table.Row>
                            <Table.HeaderCell colSpan='3'>
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
