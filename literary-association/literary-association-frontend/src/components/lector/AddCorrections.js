import {Button, Form, Modal} from "react-bootstrap";
import React from "react";

export default function AddComment(props) {

    const handleClose = () => {
        props.onHide();
    };

    return (
        <Modal centered show={props.show} onHide={handleClose} className="explanation">
            <Modal.Body className="bg-light p-5">
                <h3>Corrections</h3>
                <Form.Group controlId="synopsys" className="text-left">
                    <Form.Control as="textarea" rows={5} placeholder="Enter corrections"/>
                </Form.Group>
                <Button variant="success float-right" onClick={() => {props.setStatus("WAITING_CORRECTIONS"); props.onHide()}}>
                    ADD CORRECTIONS
                </Button>
            </Modal.Body>
        </Modal>
    );
}