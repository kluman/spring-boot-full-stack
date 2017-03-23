const React = require('react');

import * as Utils from './Utils'

export default class Company extends React.Component {

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
    if (!this.state.success) {
      return null;
    }

    return(
      <div className="Company-container">
      </div>
    )
  }
}
