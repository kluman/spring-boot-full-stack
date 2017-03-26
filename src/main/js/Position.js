import React from 'react'
import * as Utils from './Utils'
import Projects from './Projects'

export default class extends React.Component {

  render() {
    if (!this.props.title) {
      return null;
    }

    return(
      <li className="Position">
        <h3>{this.props.title}</h3>
        <div className="dates">
          <span className="start">{Utils.formatMonthYear(this.props.start)}</span>
          <span className="end">{Utils.formatMonthYear(this.props.end)}</span>
        </div>
        {
          (this.props.website) ?
            <span className="website"><a href={this.props.website}>{this.props.website}</a></span>
          : ''
        }
        <div className="responsibilities">{this.props.responsibilities}</div>
        <Projects url={this.props.projects} />
      </li>
    )
  }
}
