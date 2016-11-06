/**
 * Created by Василий on 05.11.2016.
 */
"use strict"

import React from 'react'
import {} from './style.css'

export default class Radio extends React.Component{

    constructor(props){
        super(props);
        this.state = {cook: true};
        this.revertState = this.revertState.bind(this);
    }


    revertState(e){
        this.setState({cook: !this.state.cook});
        console.log(e)
    }


    render(){

        return(
            <div>
                <div className="radio_c" >Radio 1</div>
            </div>
        )
    }

}