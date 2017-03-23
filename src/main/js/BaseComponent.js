const React = require('react');

import * as Utils from './Utils'

class BaseComponent extends React.Component {

  constructor(props) {
    super(props);

    this.state = {};
  }

  componentDidMount() {
    if (this.props.url) {
      Utils.api(this.props.url, this);
    }
  }
}

export default BaseComponent
