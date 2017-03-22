const Rest = require('rest');

/**
 * Makes AJAX request to JPA endpoint and sets the response to the state of the React component.
 *
 * @param url to JPA endpoint.
 * @param component to set state.
 */
export function api(url, component) {
  let model = component,
    _url = (url.href) ? url.href : url;

  if (typeof _url !== "string") {
    console.warn("Invalid 'url' argument!");
    return;
  }
  
  Rest(_url).then(function(response) {
    let json = {success: false, loading: false};

    if (response.status.code === 200) {
      try {
        Object.assign(json, JSON.parse(response.entity), {success: true});
        model.setState(json);

      } catch (e) {
        console.warn("Failed API request.", e);
        console.debug(_url, response, model);
      }
      
    } else {
      model.setState(json);
    }
  });
}
