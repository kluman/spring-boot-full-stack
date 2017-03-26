import React from 'react'
import Address from './Address'
import Positions from './Positions'

export default class Company extends React.Component {

  render() {
    if (!this.props.name) {
      return null;
    }

    return(
      <li className="Company">
        <h2 className="name">{this.props.name}</h2>
        <span className="website"><a href={this.props.website}>{this.props.website}</a></span>
        <Address url={this.props.address.href} />
        <Positions url={this.props.positions.href} />
      </li>
    )
  }
}
