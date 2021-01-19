import {Modal, Button, Table, ButtonGroup} from "react-bootstrap";
import React, {useEffect, useState} from "react";

export default function PlagiarismCheckResults(props) {

    const [plagiats, setPlagiats] = useState([]);

    useEffect(() => {
        if(props.selectedRequest){
            fetch("http://localhost:8080/publish/editor/plagiats/" + props.selectedRequest.processInstanceId, {
                method: "GET",
                headers: {
                    "Authorization" : "Bearer " + props.loggedIn,
                    "Content-Type": "application/json"
                }
            })
                .then(response => response.json())
                .then(data => {
                    setPlagiats(data);
                    console.log("PLAGIATS: " + JSON.stringify(data));
                })
                .catch((error) => {
                    console.log(error);
                });
        }
    }, [props.selectedRequest])

    const handleClose = () => {
        props.onHide();
    };

    const handleDecision = (decision) => {
        fetch("http://localhost:8080/publish/editor/plagiats/" + props.selectedRequest.taskId, {
            method: "POST",
            headers: {
                "Authorization" : "Bearer " + props.loggedIn,
                "Content-Type": "application/json"
            },
            body: JSON.stringify({approved: decision})
        })
            .then(response => response.json())
            .then(data => {
                console.log("SUCCESS: " + data);
            })
            .catch((error) => {
                console.log(error);
            });
        handleClose();
    }

    return (
        <Modal centered show={props.show} onHide={handleClose} className="plagiarism-check-results">
            <Modal.Body className="bg-light">
                <div className="bg-light p-5">
                    <div className="row ml-3">
                        <ButtonGroup>
                            <Button variant="success" onClick={() => handleDecision(true)}>
                                ORIGINAL
                            </Button>
                            <Button variant="danger" onClick={() => handleDecision(false)}>
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
                        {   plagiats?.map((plagiat, index) => {
                            return (
                                <tr key={plagiat.source}>
                                    <td>{index + 1}</td>
                                    <td>
                                        {plagiat.source}
                                    </td>
                                </tr>
                            )
                            })
                        }
                        </tbody>
                    </Table>
                </div>
            </Modal.Body>
        </Modal>
    )
}