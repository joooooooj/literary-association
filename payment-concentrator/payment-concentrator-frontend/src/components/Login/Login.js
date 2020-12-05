import { React } from "react";
import "./Login.scss";
import LoginIcon from "@material-ui/icons/AccountCircleSharp";
import PassIcon from "@material-ui/icons/LockSharp";

export default function LoginComponent() {
  return (
    <div className="Login">
      <div className="input-container">
        <input type="text" placeholder="Username" />
        <i>
          <LoginIcon />
        </i>
      </div>
      <div className="input-container">
        <input type="password" placeholder="Password" />
        <i>
          <PassIcon />
        </i>
      </div>
      <button type="submit" className="Button">
        Log In
      </button>
    </div>
  );
}
