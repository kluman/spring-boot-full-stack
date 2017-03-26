import React from 'react'
import BaseComponent from './BaseComponent'
import Position from './Position'

export default class extends BaseComponent {

  render() {
    if (!this.state.success
          || !this.state._embedded
          || !this.state._embedded.positions
          || !(this.state._embedded.positions.length > 0)) {
      return null;
    }
    
    return(
      <ol className="Positions">
        {this.state._embedded.positions.map((position) =>
          <Position key={position._links.self.href}
                    title={position.title}
                    start={position.start}
                    end={position.end}
                    responsibilities={position.responsibilities}
                    projects={position._links.projects.href}
          />
        )}
      </ol>
    )
  }
}
