import React, {useEffect, useState} from "react";
import {Button, Form, Modal} from "react-bootstrap";
import Select from "react-select";

export default function ChooseBetaReaders(props) {

    const [prepared, setPrepared] = useState([]);

    const handleClose = () => {
        props.onHide();
    };

    useEffect(() => {
        if (props.betaReaders){
            prepareBetaReaders();
        }
    }, [props.betaReaders]);

    const prepareBetaReaders = () => {
        let temp = [];
        props.betaReaders.readerList.forEach((reader) => {
            temp.push({value: reader.username, label: reader.username + " ( " + reader.penaltyPoints + " )"});
        })
        setPrepared(temp);
    }

    const [readers, setReaders] = useState([]);

    const handleChoose = () => {
        let filtered = readers.filter(reader => reader.value).map(reader => reader.value);
        fetch("http://localhost:8080/publish/editor/choose-beta/" + props.betaReaders.taskId, {
            method: "POST",
            headers: {
                "Authorization" : "Bearer " + props.loggedIn,
                "Content-Type": "application/json",
            },
            body: JSON.stringify(filtered)
        })
            .then(response => response.json())
            .then(data => {
                console.log(data);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    return (
        <Modal centered show={props.show} onHide={handleClose} className="choose-beta-readers">
            <Modal.Body className="p-5">
                <Form.Group controlId="beta_readers" className="text-left">
                    <Form.Label>Choose beta readers : </Form.Label>
                    <Select className="text-dark" isMulti={true} options={prepared} onChange={(selectValue) => {
                        setReaders(selectValue);
                    }}/>
                </Form.Group>
                <Button variant="success" className="float-right w-25 mt-3" onClick={() => { handleChoose(); props.onHide(); }}>
                    DONE
                </Button>
            </Modal.Body>
        </Modal>
    );
}