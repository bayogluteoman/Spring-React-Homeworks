import React from 'react'
import { Menu, Icon, Button } from 'semantic-ui-react'

export default function SideBar() {
    return (
        <div>
            <Menu  icon="labeled" vertical>
                <Menu.Item >
                    <Icon fitted size='big' name='group' />
                    <Button color='black'>Employers</Button>
                </Menu.Item>

                <Menu.Item name="bullhorn">
                    <Icon fitted size='big' name='bullhorn' />
                    <Button color='black'>Job Advertisements</Button>
                </Menu.Item>

                <Menu.Item name="user">
                    <Icon fitted size='big' name='search' />
                    <Button color='black'>Candidates</Button>
                </Menu.Item>
            </Menu>
        </div>
    )
}
