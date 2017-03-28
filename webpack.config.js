const path = require('path');
const webpack = require('webpack');

// Webpack 2 config options:  https://webpack.js.org/configuration/
module.exports = {
  resolve: {
    extensions: ['.js', '.jsx']
  },
  entry: './src/main/js/App.js',
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
      }
    ]
  }
};
