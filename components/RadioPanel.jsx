/**
 * Created by Pavlovens on 04.11.2016.
 */
"use strict"
import React, { Component } from 'react';

export default class RadioPanel extends Component{

    constructor(){
        super();
        this.state = {radioState: {}}
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange() {
        this.props.onUserInput(
            this.refs.h1input.value,
        );
    }


    render(){

        const radios = this.props.children;
         console.log(radios);
        return(
            <div>
                {radios}
            </div>
        )
    }


}