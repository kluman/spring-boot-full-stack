const React = require('react');

import * as Utils from './Utils'

export default class Address extends React.Component {

  constructor(props) {
    super(props);

    this.state = {};
  }

  componentDidMount() {
    if (this.props.url) {
      Utils.api(this.props.url, this);
    }
  }

  render() {
     return(
       <div className="Person-address" itemProp="address" itemScope itemType="http://schema.org/PostalAddress">
         <span itemProp="streetAddress">{this.state.address}</span>
         <span itemProp="addressLocality">{this.state.city}</span>,
         <span itemProp="addressRegion">{this.state.region}</span>
       </div>
     )
  }
}
