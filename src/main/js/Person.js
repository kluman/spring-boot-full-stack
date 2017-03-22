const React = require('react');

export default class Person extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
    const middle = (this.props.middle) ? <span className="Person-middle" itemProp="additionalName">{this.props.middle}</span> : '';

    return(
        <div className="Person">
          <h1 className="Person-name" itemScope itemType="http://schema.org/Person">
            <span className="Person-first" itemProp="givenName">{this.props.first}</span>
            {middle}
            <span className="Person-last" itemProp="familiyName">{this.props.last}</span>
          </h1>
        </div>
    )
  }
}
