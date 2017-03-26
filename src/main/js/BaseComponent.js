import React from 'react'
import * as Utils from './Utils'

/**
 * The base class used for all Components that will be doing JPA-AJAX requests.
 */
export default class extends React.Component {

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
