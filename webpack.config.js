var path = require('path');

module.exports = {
  entry: './src/main/js/App.js',
  output: {
    path: __dirname,
    filename: './src/main/resources/static/build/bundle.js'
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        use: [
          {
            loader: "babel-loader",
            options: {
                cacheDirectory: true,
                presets: ['es2015', 'react']
            }
          }
        ]
      }
    ]
  }
};
