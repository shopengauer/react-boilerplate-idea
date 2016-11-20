/**
 * Created by vasiliy on 13.11.16.
 */
"use strict";

import React, { Component } from 'react';
import { bindActionCreators } from 'redux'
import { connect } from 'react-redux'
import * as actionCreators from '../actions/actionsCreators'
export class Page extends Component{

   constructor(){
        super();
   }


   render(){

       const {leftPanel, rightPanel} = this.props.panelsVisible
       const { changeRightPanelVisibility} = this.props.actionCreators

       return(




           <div className="container-fluid">


               <div className="row">
                   <button type="button" onClick={(a,b)=>changeRightPanelVisibility(leftPanel,rightPanel)}>Нахать</button>

                   <div className="col-lg-6">
                       <div className="panel panel-default">
                           <div className="panel-heading">Panel heading without title</div>
                           <div className="panel-body">
                               {rightPanel}
                           </div>
                       </div>
                   </div>

                   <div className="col-lg-6">
                       <div className="panel panel-default">
                           <div className="panel-heading">Panel heading without title</div>
                           <div className="panel-body">
                               {leftPanel}
                           </div>
                       </div>
                   </div>
               </div>





           </div>
       );
   }


}

function mapStateToProps(state) {
    return {
        panelsVisible: state.panelsVisible

    }
}

function mapDispatchToProps(dispatch) {
    return {
        actionCreators: bindActionCreators(actionCreators, dispatch)
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Page)