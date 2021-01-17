import React, {useEffect, useState} from "react";
import {Button, Form} from "react-bootstrap";
import {Link} from "react-router-dom";
import CustomFormField from "../CustomFormField";
import {useForm} from "react-hook-form";

export default function Register() {

    const options = [
        {value: "Madrid_Spain", label: "Madrid, Spain"},
        {value: "Mahuma_Aruba", label: "Mahuma, Aruba"},
        {value: "Toronto_Canada", label: "Toronto, Canada"}
    ];

    const {register, errors, handleSubmit} = useForm();
    const [registerForm, setRegisterForm] = useState(null);

    useEffect(() => {
        console.error('asfasdfasdfasdf');
        fetch("http://localhost:8080/api/auth/registration/user-input-details", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        })
            .then(response => response.json())
            .then(data => {
                setRegisterForm(data);
            })
            .catch((error) => {
                console.log(error);
            });
    }, []);

    return (
        <div className="col-4 content bg-dark p-1">
            <div className="m-5 custom-form border-light border pb-5">
                <Form className="mt-5 mb-5 w-75 pb-5">
                    <h3 className="text-left pb-3">Registration</h3>
                    {registerForm.formFields.map((formField) => {
                        return (
                            <CustomFormField formField={formField} errors={errors} register={register}/>
                        )
                    })
                    }
                    {/*<Form.Group controlId="name" className="text-left">*/}
                    {/*    <Form.Label>Name</Form.Label>*/}
                    {/*    <Form.Control type="text" placeholder="Enter name"/>*/}
                    {/*</Form.Group>*/}
                    {/*<Form.Group controlId="surname" className="text-left">*/}
                    {/*    <Form.Label>Surname</Form.Label>*/}
                    {/*    <Form.Control type="text" placeholder="Enter surname"/>*/}
                    {/*</Form.Group>*/}
                    {/*<Form.Group controlId="city_state" className="text-left">*/}
                    {/*    <Form.Label>City and country</Form.Label>*/}
                    {/*    <Select className="text-dark" options={options}/>*/}
                    {/*</Form.Group>*/}
                    {/*<Form.Group controlId="email" className="text-left">*/}
                    {/*    <Form.Label>Email address</Form.Label>*/}
                    {/*    <Form.Control type="email" placeholder="Enter email"/>*/}
                    {/*</Form.Group>*/}
                    {/*<Form.Group controlId="username" className="text-left">*/}
                    {/*    <Form.Label>Username</Form.Label>*/}
                    {/*    <Form.Control type="username" placeholder="Enter username"/>*/}
                    {/*</Form.Group>*/}
                    {/*<Form.Group controlId="password" className="text-left">*/}
                    {/*    <Form.Label>Password</Form.Label>*/}
                    {/*    <Form.Control type="password" placeholder="Password"/>*/}
                    {/*</Form.Group>*/}
                    <Link to="/register-success">
                        <Button variant="success" type="submit" className="float-right w-100 mt-3">
                            I wanna be writer
                        </Button>
                    </Link>
                    <Link to="/register-reader">
                        <Button variant="primary" type="submit" className="float-right w-100 mt-3">
                            I wanna be reader
                        </Button>
                    </Link>
                </Form>
            </div>
        </div>
    );
}