import React from 'react'

export default class extends React.Component {
  
  render() {
    if (!this.props.name) {
      return null;
    }
    
    return(
      <li>
        <p className="name">{this.props.name}</p>
        <span className="degree">{this.props.degree}</span>
        <span className="graduation">
        {new Date(this.props.graduation).getFullYear()}
        </span>
        <p className="notes">{this.props.notes}</p>
      </li>
    )
  }
}
