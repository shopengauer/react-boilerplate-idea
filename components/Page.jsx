/**
 * Created by vasiliy on 13.11.16.
 */
"use strict";

import React, { Component } from 'react';
import Header from "./Header.js"
import Footer from "./Footer.js"

export default class Page extends Component{

   constructor(){
        super();
   }


   render(){

       return(


           

           <div className="container-fluid">


               <div className="row">
                   <div className="col-lg-6">
                       <div className="panel panel-default">
                           <div className="panel-heading">Panel heading without title</div>
                           <div className="panel-body">
                               Basic panel example
                           </div>
                       </div>
                   </div>

                   <div className="col-lg-6">
                       <div className="panel panel-default">
                           <div className="panel-heading">Panel heading without title</div>
                           <div className="panel-body">
                                   Basic panel example
                           </div>
                       </div>
                   </div>
               </div>





           </div>
       );
   }


}