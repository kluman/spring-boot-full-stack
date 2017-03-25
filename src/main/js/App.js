import React from 'react'
import ReactDOM from 'react-dom'
import {Router, Route} from 'react-router'

import Address from './Address'
import Education from './Education'
import Employment from './Employment'
import Person from './Person'

import * as Utils from './Utils'

class App extends React.Component {

	constructor(props) {
		super(props);

		this.state = {loading: true, first: undefined, last: undefined, middle: undefined};
	}

	componentDidMount() {
    Utils.api('/api/persons/1', this);
	}

	render() {
    if (this.state.loading) {
      return <div className="loading">Loading...</div>
      
    } else {
      return (
        <div className="App">
          <Person first={this.state.first} middle={this.state.middle} last={this.state.last} email={this.state.email} />
          <Address url={this.state._links.address} />
          <Education url={this.state._links.education} />
          <Employment url={this.state._links.employment} />
        </div>
      )
    }
	}
}

ReactDOM.render(
    <App />,
    document.getElementById('root')
);
