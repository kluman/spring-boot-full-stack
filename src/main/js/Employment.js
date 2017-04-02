import React from 'react'
import BaseComponent from './BaseComponent'
import Company from './Company'

import {
  Step,
  Stepper,
  StepButton,
  StepContent,
  StepLabel
} from 'material-ui/Stepper'
import RaisedButton from 'material-ui/RaisedButton'
import FlatButton from 'material-ui/FlatButton'

export default class Employment extends BaseComponent {

  constructor(props) {
    super(props);
                                    
    this.state = {
      stepIndex: 0
    };

    // This binding is necessary to make `this` work in the callback.
    this.handleNext = this.handleNext.bind(this);
    this.handlePrev = this.handlePrev.bind(this);
  }
  
  handleNext(e) {
    const stepIndex = this.state.stepIndex;

    if (stepIndex < 2) {
      this.setState({stepIndex: stepIndex + 1});
    }
  };

  handlePrev(e) {
    const stepIndex = this.state.stepIndex;

    if (stepIndex > 0) {
      this.setState({stepIndex: stepIndex - 1});
    }
  };

  render() {
    if (!this.state.success) {
      return null;
    }

    const stepIndex = this.state.stepIndex;
    const employment = this;

    return(
      <Stepper activeStep={stepIndex} linear={false} orientation="vertical" style={{margin: '0 auto 110px auto', width: '90%'}}>
        {this.state._embedded.companies.map((company, index) =>
          <Step key={company._links.self.href}>
            <StepButton><h2 className="Company-name">{company.name}</h2></StepButton>
            <StepContent>
              <Company key={company._links.self.href}
                     name={company.name}
                     website={company.website}
                     address={company._links.address}
                     positions={company._links.positions}

              />
              {index === 0 ? (
                  <RaisedButton
                    label="Next"
                    disableTouchRipple={true}
                    disableFocusRipple={true}
                    primary={true}
                    onTouchTap={this.handleNext}
                    style={{marginRight: 12}}
                  />
                ) : (
                  <FlatButton
                    label="Back"
                    disableTouchRipple={true}
                    disableFocusRipple={true}
                    onTouchTap={this.handlePrev}
                  />
                )
              }
            </StepContent>
          </Step>
        )}
      </Stepper>
    )
  }
}
