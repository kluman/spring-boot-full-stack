import getMuiTheme from 'material-ui/styles/getMuiTheme'
import * as colors from 'material-ui/styles/colors';

// MUI theme options are at: https://github.com/callemall/material-ui/blob/master/src/styles/getMuiTheme.js
const customTheme = getMuiTheme({
  palette: {
    textColor: colors.grey400
  },
  appBar: {
    color: colors.orange400,
    textColor: colors.blue600
  },
  person: {
    
  }
});

export { customTheme };
