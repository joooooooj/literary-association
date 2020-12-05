import React from "react";
import {Route, Switch} from "react-router-dom";
import Home from "./components/core/Home";
import Register from "./components/core/registration/Register";
import Pricing from "./components/membership/Pricing";
import ResetPassword from "./components/core/password/ResetPassword";
import RegisterSuccess from "./components/core/registration/RegisterSuccess";
import RegisterReader from "./components/core/registration/RegisterReader";
import RegisterBetaReader from "./components/core/registration/RegisterBetaReader";

export default function Routes() {
    return (
        <Switch>
            <Route exact path="/">
                <Home/>
            </Route>
            <Route exact path="/home">
                <Home/>
            </Route>
            <Route exact path="/register">
                <Register/>
            </Route>
            <Route exact path="/pricing">
                <Pricing/>
            </Route>
            <Route exact path="/reset-password">
                <ResetPassword/>
            </Route>
            <Route exact path="/register-success">
                <RegisterSuccess/>
            </Route>
            <Route exact path="/register-reader">
                <RegisterReader/>
            </Route>
            <Route exact path="/register-beta">
                <RegisterBetaReader/>
            </Route>
            <Route>
                <Home/>
            </Route>
        </Switch>
    );
}