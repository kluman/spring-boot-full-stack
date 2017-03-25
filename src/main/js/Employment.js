import React from 'react'
import BaseComponent from './BaseComponent'
import Company from './Company'

export default class extends BaseComponent {

  render() {
    if (!this.state.success) {
      return null;
    }

    // TODO: Pass Jobs, but this will be links and use Router
    
    return(
      <ol className="Employment">
        {this.state._embedded.companies.map((company) =>
          <Company key={company._links.self.href}
                   name={company.name}
                   website={company.website}
                   address={company._links.address}
          />
        )}
      </ol>
    )
  }
}
