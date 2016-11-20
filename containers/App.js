import React, { Component } from 'react';
import {render} from 'react-dom';
import Panel from "../components/Panel.jsx";
import Page from "../components/Page.jsx";
import 'bootstrap/dist/css/bootstrap.css';
import Header from "../components/Header.js"
import Footer from "../components/Footer.js"

export default class App extends Component {

  constructor(){
    super();

  }






  render(){
     return (
         <div>
             <Header/>
             <Page>

             </Page>
             <Footer/>
         </div>
    );
  }
}


