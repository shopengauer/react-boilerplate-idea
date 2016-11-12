import React, { Component } from 'react';
import {render} from 'react-dom';
import Panel from "../components/Panel.jsx";
import 'bootstrap/dist/css/bootstrap.css';

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
       <div className="container">
         <h1>Parent state {this.state.parentState}</h1>
         <Panel onUserInput = {this.handleUserInput} parentState = {this.state.parentState} />
        </div>
    );
  }
}

render(<App />, document.getElementById('root'));
