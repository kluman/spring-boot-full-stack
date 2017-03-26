import React from 'react'
import * as Utils from './Utils'

export default class extends React.Component {

  render() {
    if (!this.props.title) {
      return null;
    }

    return(
      <li>
         <h4>{this.props.title}</h4>
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
         <code>{this.props.code}</code>
      </li>
    )
  }
}
