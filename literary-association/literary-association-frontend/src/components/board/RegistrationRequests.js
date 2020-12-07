import React, {useState} from "react";
import {Table, Button, ButtonGroup} from "react-bootstrap";
import PreviewPDF from "../core/modals/PreviewPDF";
import DocumentsComments from "./DocumentsComments";

export default function RegistrationRequests() {

    const [showDocumentsComments, setShowDocumentsComments] = useState(false);

    const handleCloseDocumentsComments = () => setShowDocumentsComments(false);
    const handleShowDocumentsComments = () => setShowDocumentsComments(true);

    return (
        <div className="bg-dark p-5">
            <DocumentsComments show={showDocumentsComments} onHide={handleCloseDocumentsComments}/>
            <div className="bg-dark p-5 border border-light">
                <h2 className="text-left text-light mb-4">
                    Registration requests
                </h2>
                <Table striped bordered hover variant="dark">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>Neil</td>
                        <td>Gaiman</td>
                        <td className="text-center">
                            <Button variant="outline-light" onClick={() => handleShowDocumentsComments()}>
                                REVIEW WORK
                            </Button>
                        </td>
                        <td className="text-center">
                            <ButtonGroup>
                                <Button variant="outline-info">
                                    APPROVE
                                </Button>
                                <Button variant="outline-warning">
                                    MORE MATERIAL
                                </Button>
                                <Button variant="outline-danger">
                                    DECLINE
                                </Button>
                            </ButtonGroup>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Bernard</td>
                        <td>Cornwell</td>
                        <td className="text-center">
                            <Button variant="outline-light">
                                REVIEW WORK
                            </Button>
                        </td>
                        <td className="text-center">
                            <ButtonGroup>
                                <Button variant="outline-info">
                                    APPROVE
                                </Button>
                                <Button variant="outline-warning">
                                    MORE MATERIAL
                                </Button>
                                <Button variant="outline-danger">
                                    DECLINE
                                </Button>
                            </ButtonGroup>
                        </td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Elizabeth</td>
                        <td>Gilbert</td>
                        <td className="text-center">
                            <Button variant="outline-light">
                                REVIEW WORK
                            </Button>
                        </td>
                        <td className="text-center">
                            <ButtonGroup>
                                <Button variant="outline-info">
                                    APPROVE
                                </Button>
                                <Button variant="outline-warning">
                                    MORE MATERIAL
                                </Button>
                                <Button variant="outline-danger">
                                    DECLINE
                                </Button>
                            </ButtonGroup>
                        </td>
                    </tr>
                    </tbody>
                </Table>
            </div>
        </div>
    );
}