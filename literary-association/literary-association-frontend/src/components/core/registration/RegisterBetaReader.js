import React, {useEffect, useState} from "react";
import {Button, Form} from "react-bootstrap";
import Select from "react-select";
import {Link} from "react-router-dom";
import {useForm} from "react-hook-form";
import CustomFormField from "../CustomFormField";

export default function RegisterReader(props) {

    const genres = [
        {value: "fantasy", label: "Fantasy"},
        {value: "romance", label: "Romance"},
        {value: "thriller", label: "Thriller"}
    ];

    const {register, errors, handleSubmit} = useForm();
    const [wantedGenresForm, setWantedGenresForm] = useState(null);

    useEffect(() => {
        const url = window.location.href;
        const IdFromURL = url.split('?')[1].split('=')[1];
        fetch("http://localhost:8080/api/auth/registration/reader-preferences/" + IdFromURL, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                'Accept': 'application/json'
            },
        })
            .then(response => response.json())
            .then(data => {
                setWantedGenresForm(data);
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
        fetch('http://localhost:8080/api/auth/registration/reader-wanted-genres/' + wantedGenresForm.taskId, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify(final)
        })
            .then(response => response.json())
            .then(data => {
                window.location.replace('/register-success');
            })
            .catch((error) => {
                console.log(error)
            });
    }

    return (
        <div className="col-4 content bg-dark p-1">
            <div className="m-5 custom-form border-light border pb-5">
                {wantedGenresForm &&
                <Form className="mt-5 mb-5 w-75 pb-5" onSubmit={handleSubmit(submitFormHandler)}>
                    <h3 className="text-left pb-3">Please enter more information</h3>
                    {
                        wantedGenresForm.formFields.map((formField, index) => {
                            return (
                                <CustomFormField key={index} formField={formField} errors={errors} register={register}/>
                            );
                        })
                    }
                    <Button variant="success" type="submit" className="float-right w-100 mt-3">
                        Continue
                    </Button>
                </Form>
                }
            </div>
        </div>
    );
}