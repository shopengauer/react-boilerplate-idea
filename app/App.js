import React, { Component } from 'react';
import {render} from 'react-dom';
import RadioPanel from "../components/RadioPanel.jsx";
import Radio from "../components/Radio.jsx";

class App extends Component {

  constructor(){
    super();
    this.state = {parentState: "Kotlin"}

    this.handleUserInput = this.handleUserInput.bind(this);
  }

   handleUserInput(lang) {
        this.setState({
             parentState: lang
        });
    }



  render(){
     return (
       <div>
         <h1>Parent state {this.state.parentState}</h1>
          <RadioPanel>
            <Radio/>
            <Radio/>
            <Radio/>
            <Radio/>
       </RadioPanel>
        </div>
    );
  }
}

render(<App />, document.getElementById('root'));
