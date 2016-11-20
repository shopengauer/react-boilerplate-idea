/**
 * Created by vasiliy on 20.11.16.
 */
import { LEFT_PANEL_VISIBLE,RIGHT_PANEL_VISIBLE } from '../constants/actionsTypes'

const initialState = {
    leftPanelVis: true,
    rightPanelVis: true
}

export default function page(state = initialState, action) {

    switch (action.type) {
        case LEFT_PANEL_VISIBLE:
            return { leftPanelVis: !action.payload.leftPanelVis }

        case RIGHT_PANEL_VISIBLE:
            return { rightPanelVis: !action.payload.rightPanelVis }

        default:
            return state;
    }

}


