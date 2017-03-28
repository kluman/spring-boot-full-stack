import React from 'react'
import ReactDOM from 'react-dom'
import {Router, Route} from 'react-router'

import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider'
import CircularProgress from 'material-ui/CircularProgress'

import Address from './Address'
import Education from './Education'
import Employment from './Employment'
import Person from './Person'

import * as Utils from './Utils'
import {customTheme} from './theme'

class App extends React.Component {

	constructor(props) {
		super(props);

		this.state = {loading: true};
	}

	componentDidMount() {
    Utils.api('/api/persons/1', this);
	}

	render() {
    if (this.state.loading) {
      return (
        <MuiThemeProvider muiTheme={customTheme}>
            <CircularProgress />
        </MuiThemeProvider>
      )
      
    } else {
      return (
        <MuiThemeProvider muiTheme={customTheme}>
          <div className="App">
            <Person first={this.state.first} middle={this.state.middle} last={this.state.last} email={this.state.email} />
            <Address url={this.state._links.address} />
            <Education url={this.state._links.education} />
            <Employment url={this.state._links.employment} />
          </div>
        </MuiThemeProvider>
      )
    }
	}
}

ReactDOM.render(
    <App />,
    document.getElementById('root')
);
