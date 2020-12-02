import { Route, Switch } from "react-router";
import "./App.css";
import LoginComponent from "./components/Login/Login";
import PaymentMethodsComponent from "./components/PaymentMethods/PaymentMethods";
import Navbar from "./components/UI/Navbar/Navbar";
import WelcomeCard from "./components/WelcomeCard/WelcomeCard";

function App() {
  return (
    <div className="App" className="bg">
      <Navbar />
      <Switch>
        <WelcomeCard />
        <Route component={LoginComponent} path="/login" exact />
        <Route
          component={PaymentMethodsComponent}
          path="/payment-methods"
          exact
        />
      </Switch>
    </div>
  );
}

export default App;
