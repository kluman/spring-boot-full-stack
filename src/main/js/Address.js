const React = require('react');

import BaseComponent from './BaseComponent'

export default class extends BaseComponent {

  render() {
    if (!this.state.success) {
      return null;
    }

    return (
      <div className="Address" itemProp="address" itemScope itemType="http://schema.org/PostalAddress">
        <span itemProp="streetAddress">{this.state.address}</span>
        <span itemProp="addressLocality">{this.state.city}</span>,
        <span itemProp="addressRegion">{this.state.region}</span>
        <span itemProp="postalCode">{this.state.postalCode}</span>
        <span itemProp="telephone">{this.state.phone}</span>
      </div>
    )
  }
}
