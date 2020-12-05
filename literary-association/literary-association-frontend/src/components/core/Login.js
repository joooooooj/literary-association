import React from "react";
import {Form, Button} from "react-bootstrap";
import {Link} from "react-router-dom";

export default function Login() {

    return (
        <div className="m-5 custom-form border-light border pb-5">
            <Form className="mt-5 mb-5 w-50">
                <Form.Group controlId="formBasicEmail" className="text-left">
                    <Form.Label>Email address</Form.Label>
                    <Form.Control type="email" placeholder="Enter email" />
                </Form.Group>
                <Form.Group controlId="formBasicPassword" className="text-left">
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="password" placeholder="Password" />
                </Form.Group>
                <Form.Text className="text-muted text-left">
                    <Link to="/reset-password">Forgot your password?</Link>
                </Form.Text>
                <Form.Text className="text-muted text-left">
                    <Link to="/registration">Don't have an account? Sign up.</Link>
                </Form.Text>
                <Button variant="primary" type="submit" className="float-right w-100 mt-3">
                    Login
                </Button>
            </Form>
        </div>
    );
}