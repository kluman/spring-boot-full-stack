import React from 'react'
import Address from './Address'

export default class Company extends React.Component {

  render() {
    if (!this.props.name) {
      return null;
    }

    return(
      <li className="Company">
        <p className="name">{this.props.name}</p>
        <span className="website">{this.props.website}</span>
        <Address url={this.props.address.href} />
      </li>
    )
  }
}
