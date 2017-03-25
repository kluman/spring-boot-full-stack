import React from 'react'
import * as Utils from './Utils'

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
