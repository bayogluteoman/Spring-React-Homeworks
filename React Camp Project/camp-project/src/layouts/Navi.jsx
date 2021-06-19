import React from 'react'
import { Menu, Segment,Button } from 'semantic-ui-react'
import { Link } from "react-router-dom";

export default function Navi() {
    return (
        <div>
            <Segment inverted>
                <Menu inverted pointing fixed ="top" size = "huge">
                    <Menu.Item as={Link} to='/'
                        name='home'
                    />
                    <Menu.Item as={Link} to='/activateJobAdvertisement'
                        name='Activate Job Advertisement'
                    />
                    <Menu.Item
                        name='Create Cv'
                    />
                    
                <Menu.Menu position='right'>
                <Menu.Item>
                    <Button primary position='right'>Sign up</Button>
                </Menu.Item>

                <Menu.Item>
                    <Button position='right'>Log-in</Button>
                </Menu.Item>
                    </Menu.Menu>


                </Menu>
            </Segment>
        </div>

    )
}
