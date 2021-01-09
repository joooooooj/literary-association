import {Button, Form, Modal} from "react-bootstrap";
import React from "react";
import CustomFormField from "../../../core/CustomFormField";
import {useForm} from "react-hook-form";

export default function AddExplanation(props) {

    // REACT-HOOK-FORM
    const {register, errors, handleSubmit} = useForm();
    const onSubmit = (data) => {
        let final = prepareDataForSubmit(data);
        fetch("http://localhost:8080/publish/editor/refuse/" + props.editorRefuseForm.taskId, {
            method: "POST",
            headers: {
                "Authorization" : "Bearer " + props.loggedIn,
                "Content-Type": "application/json",
            },
            body: JSON.stringify(final)
        })
            .then(response => response)
            .then(data => {
                handleClose();
            })
            .catch((error) => {
                console.log(error);
            });
    }

    const prepareDataForSubmit = (data) => {
        let final = [];
        for(let prop in data){
            final.push({fieldId:prop, fieldValue:data[prop]})
        }
        return final;
    }

    const handleClose = () => {
        props.onHide();
    };

    return (
        <Modal centered show={props.show} onHide={handleClose} backdrop="static" className="explanation">
            <Modal.Body className="bg-light p-5">
                <h3>Explanation</h3>
                <Form className="mt-5 mb-5 w-100" onSubmit={handleSubmit(onSubmit)}>
                    {props.editorRefuseForm.formFields.map((formField) => {
                        return (
                            <CustomFormField formField={formField} errors={errors} register={register}/>
                        )
                    })
                    }
                    <Button variant="success float-right" type="submit">
                        SEND EXPLANATION
                    </Button>
                </Form>
            </Modal.Body>
        </Modal>
    );
}