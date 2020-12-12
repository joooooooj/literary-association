import React from "react";
import {Button, Form, Modal} from "react-bootstrap";
import Select from "react-select";
import {Link} from "react-router-dom";

export default function ChooseBetaReaders(props) {

    const betaReaders = [
        { value: "1", label: "Ali Mackenzie" },
        { value: "2", label: "Alana Singleton" },
        { value: "3", label: "Leonidas Wilson" },
        { value: "4", label: "Francesca Douglas" },
        { value: "5", label: "Tianna Mccoy" },
        { value: "6", label: "Kerrie Cortez" },
    ];

    const handleClose = () => {
        props.onHide();
    };

    return (
        <Modal centered show={props.show} onHide={handleClose} className="choose-beta-readers">
            <Modal.Body className="p-5">
                <Form.Group controlId="beta_readers" className="text-left">
                    <Form.Label>Choose beta readers : </Form.Label>
                    <Select className="text-dark" isMulti={true} options={betaReaders}/>
                </Form.Group>
                <Button variant="success" className="float-right w-25 mt-3" onClick={() => { props.setStatus("WAITING_BETA_READERS"); props.onHide(); }}>
                    DONE
                </Button>
            </Modal.Body>
        </Modal>
    );
}