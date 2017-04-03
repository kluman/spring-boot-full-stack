const path = require('path');
const webpack = require('webpack');

// Webpack 2 config options:  https://webpack.js.org/configuration/
module.exports = {
  context: path.resolve(__dirname, "src/main"),
  entry: './js/App.js',
  output: {
    path: __dirname,
    filename: './src/main/resources/static/build/bundle.js'
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /(node_modules|bower_components)/,
        use: [
          {
            loader: "babel-loader",
            options: {
                cacheDirectory: false,
                presets: ['es2015', 'react']
            }
          }
        ]
      },
      {
        test: /\.less$/,
        use: [
          {
            loader: "style-loader"
          },
          {
            loader: "css-loader"
          },
          {
            loader: "less-loader"
          }
        ]
      },
      {
        test: /\.(jpg|gif|png)$/,
        use: [
          {
            loader: "url-loader"
          }
        ]
      }
    ]
  }
};
