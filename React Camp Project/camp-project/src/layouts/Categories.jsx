import React from 'react'
import { Menu,Icon } from 'semantic-ui-react'
import { Link } from "react-router-dom";


export default function Categories() {
  return (
    <div>
      <Menu pointing secondary vertical size="big" position='left'>
      <Menu.Item as={Link} to='/JobList'>
          <Icon name='briefcase' />
          Job
        </Menu.Item>
        <Menu.Item
          name='Candidates'
        />
        <Menu.Item
          name='Employers'
        />
        <Menu.Item as={Link} to='/jobAdvertisement'>
          <Icon name='briefcase' />
          Job Advertisement
        </Menu.Item>


      </Menu>
    </div>
  )
}
