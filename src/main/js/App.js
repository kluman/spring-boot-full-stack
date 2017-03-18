const React = require('react');
const ReactDOM = require('react-dom');

import Person from './Person'

class App extends React.Component {

	constructor(props) {
		super(props);

		// this.state = {foo: 'bar'};
	}

	// componentDidMount() {
	// 	client({method: 'GET', path: '/api/employees'}).done(response => {
	// 		this.setState({employees: response.entity._embedded.employees});
	// 	});
	// }

	render() {
    return (
        <div className="App">
          <Person first="Kevin" last="Luman" />
        </div>
    )
	}
}

ReactDOM.render(
    <App />,
    document.getElementById('root')
);
