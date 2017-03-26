import React from 'react'
import BaseComponent from './BaseComponent'
import University from './University'

export default class extends BaseComponent {
  
  render() {
    if (!this.state.success
      || !this.state._embedded
      || !this.state._embedded.universities
      || !(this.state._embedded.universities.length > 0)) {
      return null;
    }

    return(
      <ul className="University-container">
        {this.state._embedded.universities.map((university) =>
          <University key={university._links.self.href}
                      name={university.name}
                      degree={university.degree}
                      graduation={university.graduation}
                      notes={university.notes}
          />
        )}
      </ul>
    )
  }
}
