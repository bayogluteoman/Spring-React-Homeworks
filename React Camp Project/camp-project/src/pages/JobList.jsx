import React, { useState, useEffect } from "react";
import { Icon, Menu, Table } from "semantic-ui-react";
import JobService from "../services/jobService";


export default function JobList() {
    const [jobs, setJobs] = useState([]);

    useEffect(() => {
        let jobService = new JobService()
        jobService.getJobs().then(result => setJobs(result.data.data))
    }, [])
    return (
        <div>
            <Table celled>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>Job</Table.HeaderCell>
                        <Table.HeaderCell>City</Table.HeaderCell>
                        <Table.HeaderCell>Min Wage</Table.HeaderCell>
                        <Table.HeaderCell>Max Wage</Table.HeaderCell>
                        <Table.HeaderCell>Num of Position</Table.HeaderCell>
                        <Table.HeaderCell>Publish Date</Table.HeaderCell>
                        <Table.HeaderCell>Active</Table.HeaderCell>
                        <Table.HeaderCell>Last Apply Date</Table.HeaderCell>
                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    {jobs.map((job) => (
                        <Table.Row key={job.id} >
                            <Table.Cell>{job.jobInfo}</Table.Cell>
                            <Table.Cell>{job.cities}</Table.Cell>
                            <Table.Cell>{job.min_wage}</Table.Cell>
                            <Table.Cell>{job.max_wage}</Table.Cell>
                            <Table.Cell>{job.num_of_position}</Table.Cell>
                            <Table.Cell>{job.publishDate}</Table.Cell>
                            <Table.Cell>{job.activated}</Table.Cell>
                            <Table.Cell>{job.last_apply_date}</Table.Cell>
                        </Table.Row>
                    ))}
                </Table.Body>

                <Table.Footer>
                    <Table.Row>
                        <Table.HeaderCell colSpan="8">
                            <Menu floated="right" pagination>
                                <Menu.Item as="a" icon>
                                    <Icon name="chevron left" />
                                </Menu.Item>
                                <Menu.Item as="a">1</Menu.Item>
                                <Menu.Item as="a">2</Menu.Item>
                                <Menu.Item as="a">3</Menu.Item>
                                <Menu.Item as="a">4</Menu.Item>
                                <Menu.Item as="a" icon>
                                    <Icon name="chevron right" />
                                </Menu.Item>
                            </Menu>
                        </Table.HeaderCell>
                    </Table.Row>
                </Table.Footer>
            </Table>
        </div>
    )
}
