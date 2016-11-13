import React, { Component } from 'react';
import {render} from 'react-dom';
import Panel from "../components/Panel.jsx";
import Page from "../components/Page.jsx";
import 'bootstrap/dist/css/bootstrap.css';
import Header from "../components/Header.js"
import Footer from "../components/Footer.js"

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
        <Page>
            <Header/>
            <Footer/>
        </Page>
    );
  }
}

render(<App />, document.getElementById('root'));
