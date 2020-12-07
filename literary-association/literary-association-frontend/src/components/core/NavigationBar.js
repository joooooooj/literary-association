import React from "react";
import {Navbar, Nav} from "react-bootstrap";
import {Link} from "react-router-dom";

export default function NavigationBar(){
    return (
        <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark" className="mb-5">
            <Navbar.Brand href="#home">Books & Beyond</Navbar.Brand>
            <Navbar.Toggle aria-controls="responsive-navbar-nav" />
            <Navbar.Collapse id="responsive-navbar-nav">
                <Nav className="mr-auto">
                    <Link className="nav-link" to="/home">Home</Link>
                    <Link className="nav-link" to="/books">Books</Link>
                    <Link className="nav-link" to="/pricing">Pricing</Link>
                </Nav>
                <Nav className="">
                    <Link className="nav-link" to="/registration-requests">Registration requests (Board)</Link>
                    <Link className="nav-link" to="/publish-book">Publish book (Writer)</Link>
                    <Link className="nav-link" to="/submitted-work">Submitted work (Writer)</Link>
                </Nav>
            </Navbar.Collapse>
        </Navbar>
    );
}