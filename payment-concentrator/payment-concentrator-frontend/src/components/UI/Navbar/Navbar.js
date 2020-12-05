import React from "react";
import { Nav, Navbar } from "react-bootstrap";
import Logo from "../../../images/payment.png";
import LoginIcon from "@material-ui/icons/AccountCircleSharp";
import { NavLink } from "react-router-dom";

export default function navbar() {
  return (
    <Navbar bg="light" variant="light">
      <Navbar.Brand href="/">
        <img
          alt=""
          src={Logo}
          width="30"
          height="30"
          className="d-inline-block align-top"
        />{" "}
        Payment Center
      </Navbar.Brand>
      <Nav className="mr-auto">
        <NavLink to="/payment-methods">Payment methods</NavLink>
      </Nav>
      <NavLink to="/login" bg="light" variant="light">
        <LoginIcon />
        Login
      </NavLink>
    </Navbar>
  );
}
