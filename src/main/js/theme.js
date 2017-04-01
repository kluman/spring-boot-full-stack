import getMuiTheme from 'material-ui/styles/getMuiTheme'
import * as colors from 'material-ui/styles/colors';

const colorPrimary = colors.lightGreen200,
  colorSecondary = colors.lightGreen500,
  colorHighlight = colors.lightGreen700,
  colorText = colors.grey800,
  colorTextAlternate = colors.grey400;

/* --- MUI theme options ---
 *    https://github.com/callemall/material-ui/blob/master/src/styles/getMuiTheme.js
 */
const customTheme = getMuiTheme({
  palette: {
    textColor: colorText,
    alternateTextColor: colorTextAlternate
  },

  flatButton: {
    color: colors.grey100,
    textColor: colorHighlight
  },

  raisedButton: {
    primaryColor: colorPrimary,
    textColor: colors.white,
    primaryTextColor: colors.white
  },

  stepper: {
    iconColor: colorPrimary
  },
  
  toolbar: {
    color: colorSecondary,
    backgroundColor: colorPrimary
  }
});

export { customTheme };
