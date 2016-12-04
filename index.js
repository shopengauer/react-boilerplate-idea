/**
 * Created by vasiliy on 20.11.16.
 */
import React from 'react'
import { render } from 'react-dom'
import { createStore } from 'redux'
import { Provider } from 'react-redux'
import App from './public/containers/App'
import reducer from './public/reducers'
import configureStore from './public/store/configureStore'

const store =  configureStore()

render(
    <Provider store={store}>
        <App />
    </Provider>,
    document.getElementById('root')
);



