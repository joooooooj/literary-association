import {Button, Form, Modal} from "react-bootstrap";
import React from "react";

export default function AddComment(props) {

    const handleClose = () => {
        props.onHide();
    };

    return (
        <Modal centered show={props.show} onHide={handleClose} className="explanation">
            <Modal.Body className="bg-light p-5">
                <h3>Comment</h3>
                <Form.Group controlId="synopsys" className="text-left">
                    <Form.Control as="textarea" rows={5} placeholder="Enter comment"/>
                </Form.Group>
                <Button variant="success float-right">
                    ADD COMMENT
                </Button>
            </Modal.Body>
        </Modal>
    );
}