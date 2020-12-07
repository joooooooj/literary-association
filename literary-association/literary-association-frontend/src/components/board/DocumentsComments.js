import React, {useState} from "react";
import {Button, Form, Modal, Table} from "react-bootstrap";
import PreviewPDF from "../core/modals/PreviewPDF";

export default function DocumentsComments(props) {

    const [showDocument, setShowDocument] = useState(false);

    const handleClose = () => {
        props.onHide();
    };

    const handleCloseDocument = () => setShowDocument(false);
    const handleShowDocument = () => setShowDocument(true);

    return (
        <Modal centered show={props.show} onHide={handleClose} className="documents-comments">
            <Modal.Body className="bg-light">
                <div className="bg-light p-5">
                    <PreviewPDF show={showDocument} onHide={handleCloseDocument}/>
                    <Table striped bordered hover variant="light">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Comment</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>
                                <Form className="">
                                    <Form.Group controlId="comment" className="text-left">
                                        <Form.Control as="textarea" rows={3} placeholder="Enter comment" />
                                    </Form.Group>
                                    <Button variant="outline-dark" type="submit" className="float-right">
                                        ADD COMMENT
                                    </Button>
                                </Form>
                            </td>
                            <td className="text-center">
                                <Button variant="info" onClick={() => handleShowDocument()}>
                                    PREVIEW WORK
                                </Button>
                            </td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>
                                <Form className="">
                                    <Form.Group controlId="comment" className="text-left">
                                        <Form.Control as="textarea" rows={3} placeholder="Enter comment" />
                                    </Form.Group>
                                    <Button variant="outline-dark" type="submit" className="float-right">
                                        ADD COMMENT
                                    </Button>
                                </Form>
                            </td>
                            <td className="text-center">
                                <Button variant="info">
                                    PREVIEW WORK
                                </Button>
                            </td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>
                                <Form className="">
                                    <Form.Group controlId="comment" className="text-left">
                                        <Form.Control as="textarea" rows={3} placeholder="Enter comment" />
                                    </Form.Group>
                                    <Button variant="outline-dark" type="submit" className="float-right">
                                        ADD COMMENT
                                    </Button>
                                </Form>
                            </td>
                            <td className="text-center">
                                <Button variant="info">
                                    PREVIEW WORK
                                </Button>
                            </td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>
                                <Form className="">
                                    <Form.Group controlId="comment" className="text-left">
                                        <Form.Control as="textarea" rows={3} placeholder="Enter comment" />
                                    </Form.Group>
                                    <Button variant="outline-dark" type="submit" className="float-right">
                                        ADD COMMENT
                                    </Button>
                                </Form>
                            </td>
                            <td className="text-center">
                                <Button variant="info">
                                    PREVIEW WORK
                                </Button>
                            </td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td>
                                <Form className="">
                                    <Form.Group controlId="comment" className="text-left">
                                        <Form.Control as="textarea" rows={3} placeholder="Enter comment" />
                                    </Form.Group>
                                    <Button variant="outline-dark" type="submit" className="float-right">
                                        ADD COMMENT
                                    </Button>
                                </Form>
                            </td>
                            <td className="text-center">
                                <Button variant="info">
                                    PREVIEW WORK
                                </Button>
                            </td>
                        </tr>
                        </tbody>
                    </Table>
                </div>
            </Modal.Body>
        </Modal>
    );
}