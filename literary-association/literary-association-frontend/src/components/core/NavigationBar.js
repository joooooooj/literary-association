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
                    <Link className="nav-link text-info" to="/registration-requests">Registration requests (Board)</Link>
                    <Link className="nav-link text-info" to="/submitted-work">Submitted work (Writer)</Link>
                </Nav>
                <Nav className="">
                    <Link className="nav-link text-danger" to="/publish-book">Publish book (Writer)</Link>
                    <Link className="nav-link text-danger" to="/publish-requests">Publish requests (Editor)</Link>
                    <Link className="nav-link text-danger" to="/corrections-scripts">Correction requests (Lector)</Link>
                    <Link className="nav-link text-danger" to="/comments-scripts">Review scripts (Beta)</Link>
                </Nav>
                <Nav className="">
                    <Link className="nav-link text-success" to="/plagiarism-complaint">Plagiarism complaint (Writer)</Link>
                    <Link className="nav-link text-success" to="/main-editor-complaints">Main editor complaints (Main editor)</Link>
                    <Link className="nav-link text-success" to="/notes-complaints">Complaint note requests (Editor)</Link>
                    <Link className="nav-link text-success" to="/review-notes">Review notes (Board)</Link>
                </Nav>
            </Navbar.Collapse>
        </Navbar>
    );
}