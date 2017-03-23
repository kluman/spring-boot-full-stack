const React = require('react');

import BaseComponent from './BaseComponent'

export default class extends BaseComponent {

  render() {
    if (!this.state.success) {
      return null;
    }

    const companies = this.state._embedded.companies.map((company) =>
          <li className="Company" key={company._links.self.href}>
            <p className="name">{company.name}</p>
          </li>
        );

    return(
      <ol className="Employment">
        {companies}
      </ol>
    )
  }
}
