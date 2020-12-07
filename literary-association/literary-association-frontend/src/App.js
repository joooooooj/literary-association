import React from "react";

import "./styles/app.scss";
import NavigationBar from "./components/core/NavigationBar";
import Routes from "./Routes";

function App() {
  return (
    <div className="app">
      <NavigationBar/>
      <div className="container-fluid mb-5">
          <Routes/>
      </div>
    </div>
  );
}

export default App;
