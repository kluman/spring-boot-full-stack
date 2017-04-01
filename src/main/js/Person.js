import React from 'react'
import BaseComponent from './BaseComponent'

import {
  Toolbar,
  ToolbarGroup,
  ToolbarSeparator,
  ToolbarTitle
} from 'material-ui/Toolbar'

// Needed for onTouchTap
import injectTapEventPlugin from 'react-tap-event-plugin';
injectTapEventPlugin();

export default class Person extends BaseComponent {
  
  render() {
    const middle = (this.props.middle) ? <span itemProp="additionalName">{this.props.middle}</span> : '';

    return(
      <div className="Person">
        <Toolbar className="Person-toolbar" noGutter={true}>
          <ToolbarGroup>
           <ToolbarTitle text={this.props.fullName} className="Person-toolbar-name" style={{color: '#fff', paddingLeft: '20px'}} />
          </ToolbarGroup>
        </Toolbar>

        <div itemScope itemType="http://schema.org/Person">
          <span itemProp="givenName">{this.props.first}</span>
          {middle}
          <span itemProp="familiyName">{this.props.last}</span>
        </div>

        <div itemProp="email">{this.props.email}</div>
      </div>
    )
  }
}
