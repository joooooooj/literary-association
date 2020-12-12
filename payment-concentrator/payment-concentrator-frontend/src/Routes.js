import React from "react";
import {Redirect, Route, Switch} from "react-router";
import WelcomeCard from "./components/WelcomeCard/WelcomeCard";
import LoginComponent from "./components/Login/Login";
import PaymentMethodsComponent from "./components/PaymentMethods/PaymentMethods";
import AdminDashboard from "./components/AdminDashboard/AdminDashboard";

export default function Routes(props) {
    return (<Switch>
        <Route component={WelcomeCard} path="/" exact/>
        <Route render={() => (<LoginComponent log={props.log}/>)} path="/login" exact/>
        <Route
            component={PaymentMethodsComponent}
            path="/payment-methods"
            exact
        />
        {(props.loggedIn === true || localStorage.getItem("token") !== null) ?
            <Route component={AdminDashboard} path="/dashboard" exact/> : <Redirect to="/"/>}
    </Switch>);
}