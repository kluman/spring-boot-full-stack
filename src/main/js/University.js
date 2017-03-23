const React = require('react');

import * as Utils from './Utils'

export default class University extends React.Component {

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
    if (!this.state.success
      || !this.state._embedded
      || !this.state._embedded.universities
      || !(this.state._embedded.universities.length > 0)) {
      return null;
    }

    const universities = this.state._embedded.universities.map((university) =>
      <li className="University" key={university._links.self.href}>
        <p>{university.name}</p>
      </li>
    );

    return(
      <ul className="University-container">
        {universities}
      </ul>
    )
  }
}
