const React = require('react');

import BaseComponent from './BaseComponent'

export default class extends BaseComponent {
  
  render() {
    if (!this.state.success
      || !this.state._embedded
      || !this.state._embedded.universities
      || !(this.state._embedded.universities.length > 0)) {
      return null;
    }

    // TODO: this is odd - why is University a bunch of schools...should this be Education? Yes?
    // TODO: can we make a University component and just create them here passing in params! (same for Employment)
    const universities = this.state._embedded.universities.map((university) =>
      <li className="University" key={university._links.self.href}>
        <p className="name">{university.name}</p>
        <span className="degree">{university.degree}</span>
        <span className="graduation">
        {new Date(university.graduation).getFullYear()}
        </span>
        <p className="notes">{university.notes}</p>
      </li>
    );

    return(
      <ul className="University-container">
        {universities}
      </ul>
    )
  }
}
