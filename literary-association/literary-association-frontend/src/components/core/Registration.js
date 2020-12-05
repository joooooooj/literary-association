import React from "react";
import ReaderRegistration from "./ReaderRegistration";
import WriterRegistration from "./WriterRegistration";
import {Button, Form} from "react-bootstrap";
import {Link} from "react-router-dom";
import Select from 'react-select'

export default function Registration() {

    const options = [
        { value: 'Madrid_Spain', label: 'Madrid, Spain' },
        { value: 'Mahuma_Aruba', label: 'Mahuma, Aruba' },
        { value: 'Toronto_Canada', label: 'Toronto, Canada' }
    ]

    return (
        <div className="col-4 content bg-dark p-1">
            <div className="m-5 custom-form border-light border pb-5">
                <Form className="mt-5 mb-5 w-50">
                    <Form.Group controlId="name" className="text-left">
                        <Form.Label>Name</Form.Label>
                        <Form.Control type="text" placeholder="Enter name" />
                    </Form.Group>
                    <Form.Group controlId="surname" className="text-left">
                        <Form.Label>Surname</Form.Label>
                        <Form.Control type="text" placeholder="Enter surname" />
                    </Form.Group>
                    <Form.Group controlId="city_state" className="text-left">
                        <Form.Label>City and country</Form.Label>
                        <Select className="text-dark" options={options}/>
                    </Form.Group>
                    <Form.Group controlId="email" className="text-left">
                        <Form.Label>Email address</Form.Label>
                        <Form.Control type="email" placeholder="Enter email" />
                    </Form.Group>
                    <Form.Group controlId="password" className="text-left">
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
        </div>
    );
}