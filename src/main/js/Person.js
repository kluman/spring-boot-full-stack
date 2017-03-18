const React = require('react');

export default class Person extends React.Component {

  constructor(props) {
    super(props);

    this.state = {first: props.first, last: props.last};
  }

  render() {
    return(
        <h1 className="Person-name">
          <span className="Person-first">{this.state.first}</span>
          <span className="Person-last">{this.state.last}</span>
        </h1>
    )
  }
}
