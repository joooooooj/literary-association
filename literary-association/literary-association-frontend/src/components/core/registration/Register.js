import React, {useEffect, useState} from "react";
import {Button, Form} from "react-bootstrap";
import {Link} from "react-router-dom";
import CustomFormField from "../CustomFormField";
import {useForm} from "react-hook-form";

export default function Register(history) {

    const options = [
        {value: "Madrid_Spain", label: "Madrid, Spain"},
        {value: "Mahuma_Aruba", label: "Mahuma, Aruba"},
        {value: "Toronto_Canada", label: "Toronto, Canada"}
    ];

    const {register, errors, handleSubmit} = useForm();
    const [registerForm, setRegisterForm] = useState(null);

    const [isWriter, setIsWriter] = useState(false);
    const [isBetaReader, setIsBetaReader] = useState(false);

    useEffect(() => {
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

    const prepareDataForSubmit = (data) => {
        let final = [];
        for (let prop in data) {
            final.push({fieldId: prop, fieldValue: data[prop]})
        }
        return final;
    }

    const submitFormHandler = (data) => {
        let final = prepareDataForSubmit(data);
        fetch('http://localhost:8080/api/auth/registration/' + registerForm.taskId + '/' + isWriter + '/' + isBetaReader, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify(final)
        })
            .then(response => response.json())
            .then(data => {
                console.error(data);

                if (isBetaReader) {
                    window.location.href = '/register-beta-reader?id=' + data.processInstanceId;
                } else {
                    window.location.replace('/register-success');
                }
            })
            .catch((error) => {
                console.log(error)
            });
    }

    return (
        <div className="col-4 content bg-dark p-1">
            <div className="m-5 custom-form border-light border pb-5">
                {registerForm &&
                <Form className="mt-5 mb-5 w-75 pb-5" onSubmit={handleSubmit(submitFormHandler)}>
                    <h3 className="text-left pb-3">Registration</h3>
                    {registerForm.formFields.map((formField, index) => {
                        return (
                            <CustomFormField key={index} formField={formField} errors={errors} register={register}/>
                        )
                    })
                    }
                    <Button variant="success" type="submit" className="float-right w-100 mt-3"
                            onClick={() => setIsWriter(true)}
                    >
                        I wanna be writer
                    </Button>
                    <Button variant="warning" type="submit" className="float-right w-100 mt-3">
                        I wanna be reader
                    </Button>
                    <Button variant="primary" type="submit" className="float-right w-100 mt-3"
                            onClick={() => setIsBetaReader(true)}>
                        I wanna be beta reader
                    </Button>
                </Form>
                }
            </div>
        </div>
    );
}