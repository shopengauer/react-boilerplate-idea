/**
 * Created by vasiliy on 20.11.16.
 */
"use strict"

import {
         LEFT_PANEL_VISIBLE,
         RIGHT_PANEL_VISIBLE
        } from "../constants/actionsTypes"


const changeRightPanelVisibility = (visible) => ({
    type: RIGHT_PANEL_VISIBLE,
    payload: {rightPanelVis: visible}
});

const changeLeftPanelVisibility = (visible) => ({
    type: LEFT_PANEL_VISIBLE,
    payload: {leftPanelVis: visible}
});