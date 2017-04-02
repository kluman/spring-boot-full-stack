import React from 'react'
import BaseComponent from './BaseComponent'
import Project from './Project'

export default class Projects extends BaseComponent {

  render() {
    if (!this.state.success
          || !this.state._embedded
          || !this.state._embedded.projects
          || !(this.state._embedded.projects.length > 0)) {
      return null;
    }

    return(
      <div className="Projects">
        <h4>Projects</h4>
        <ol className="Projects-list">
          {this.state._embedded.projects.map((project) =>
            <Project key={project._links.self.href}
                     title={project.title}
                     start={project.start}
                     end={project.end}
                     responsibilities={project.responsibilities}
                     code={project.code}
            />
          )}
        </ol>
      </div>
    )
  }
}
