import {Modal, Button, Table, ButtonGroup} from "react-bootstrap";
import React from "react";

export default function PreviewComments(props) {

    const handleClose = () => {
        props.onHide();
    };

    return (
        <Modal centered show={props.show} onHide={handleClose} className="plagiarism-check-results">
            <Modal.Body className="bg-light">
                <div className="bg-light p-5">
                    <div className="row ml-3">
                        <ButtonGroup>
                            <Button variant="success" onClick={() => {props.setStatus("WAITING_READING"); props.onHide();}}>
                                ORIGINAL
                            </Button>
                            <Button variant="danger" onClick={() => {props.handleShowExplanation(); props.onHide();}}>
                                PLAGIAT
                            </Button>
                        </ButtonGroup>
                    </div>
                    <Table striped bordered hover variant="light">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Source</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>
                                https://www.w3schools.com/colors/colors_picker.asp
                            </td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>
                                https://react-bootstrap.netlify.app/components/button-group/
                            </td>
                        </tr>
                        </tbody>
                    </Table>
                </div>
            </Modal.Body>
        </Modal>
    )
}