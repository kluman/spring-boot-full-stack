const React = require('react');

export default class Person extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
    const middle = (this.props.middle) ? <span itemProp="additionalName">{this.props.middle}</span> : '';

    return(
      <div className="Person">
        <h1 itemScope itemType="http://schema.org/Person">
          <span itemProp="givenName">{this.props.first}</span>
          {middle}
          <span itemProp="familiyName">{this.props.last}</span>
        </h1>
        <span itemProp="email">{this.props.email}</span>
      </div>
    )
  }
}
