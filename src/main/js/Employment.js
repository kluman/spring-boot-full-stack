import React from 'react'
import BaseComponent from './BaseComponent'
import Company from './Company'

export default class Employment extends BaseComponent {

  render() {
    if (!this.state.success) {
      return null;
    }
    
    return(
      <ol className="Employment">
        {this.state._embedded.companies.map((company) =>
          <Company key={company._links.self.href}
                   name={company.name}
                   website={company.website}
                   address={company._links.address}
                   positions={company._links.positions}
                   
          />
        )}
      </ol>
    )
  }
}
