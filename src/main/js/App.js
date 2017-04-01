import React from 'react'
import ReactDOM from 'react-dom'
import {Router, Route} from 'react-router'

import {BottomNavigation, BottomNavigationItem} from 'material-ui/BottomNavigation'
import CircularProgress from 'material-ui/CircularProgress'
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider'
import {
  Toolbar,
  ToolbarGroup,
  ToolbarSeparator,
  ToolbarTitle
} from 'material-ui/Toolbar'

import Address from './Address'
import Education from './Education'
import Employment from './Employment'
import Person from './Person'

import * as Utils from './Utils'
import {customTheme} from './theme'

// Webpack will treat this like any other module and the style+less loaders will insert style tags with the compiled CSS.
import '../styles/App.less'

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
            <Toolbar className="Person-toolbar" noGutter={true}>
              <ToolbarGroup>
               <ToolbarTitle text={this.state.fullName} className="Person-toolbar-name" style={{color: '#fff', paddingLeft: '20px'}} />
              </ToolbarGroup>
            </Toolbar>

            <div className="App-info">
              <Person first={this.state.first} middle={this.state.middle} last={this.state.last}
                      email={this.state.email} fullName={this.state.fullName} />
              <Address url={this.state._links.address} />
              <Education url={this.state._links.education} />
            </div>
            <Employment url={this.state._links.employment} />

            <footer>
              <p>Spring Boot, React and Material-UI</p>
            </footer>
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
