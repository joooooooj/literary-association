import React from "react";
import {Route, Switch} from "react-router-dom";
import Home from "./components/core/Home";
import Registration from "./components/core/Registration";
import Pricing from "./components/core/Pricing";
import ResetPassword from "./components/core/ResetPassword";

export default function Routes() {
    return (
        <Switch>
            <Route exact path="/">
                <Home/>
            </Route>
            <Route exact path="/home">
                <Home/>
            </Route>
            <Route exact path="/registration">
                <Registration/>
            </Route>
            <Route exact path="/pricing">
                <Pricing/>
            </Route>
            <Route exact path="/reset-password">
                <ResetPassword/>
            </Route>
            <Route>
                <Home/>
            </Route>
        </Switch>
    );
}