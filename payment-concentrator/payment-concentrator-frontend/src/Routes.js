import React from "react";
import {Route, Switch} from "react-router";
import WelcomeCard from "./components/WelcomeCard/WelcomeCard";
import LoginComponent from "./components/Login/Login";
import PaymentMethodsComponent from "./components/PaymentMethods/PaymentMethods";
import AdminDashboard from "./components/AdminDashboard/AdminDashboard";

export default function Routes() {
    return (<Switch>
        <Route component={WelcomeCard} path="/" exact/>
        <Route component={LoginComponent} path="/login" exact/>
        <Route
            component={PaymentMethodsComponent}
            path="/payment-methods"
            exact
        />
        <Route component={AdminDashboard} path="/dashboard" exact/>
    </Switch>);
}