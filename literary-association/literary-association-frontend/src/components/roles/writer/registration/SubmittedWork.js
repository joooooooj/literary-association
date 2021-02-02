import React, {useEffect, useState} from "react";
import {Button, Table, Form} from "react-bootstrap";
import PreviewComments from "./PreviewComments";
import PreviewPDF from "../../../core/modals/PreviewPDF";
import Confirmation from "../../../core/modals/Confirmation";
import CustomForm from "../../../core/CustomForm";

export default function SubmittedWork() {

    // const [submitted, setSubmitted] = useState(true);
    //
    // const [allReviewed, setAllReviewed] = useState(false);
    //
    // const [attemptsNumber, setAttemptsNumber] = useState(2);

    const [membershipRequest, setMembershipRequest] = useState(null);
    const [publishWorkForm, setPublishWorkForm] = useState(null);

    useEffect(() => {
        const token = JSON.parse(localStorage.getItem("token"));
        fetch('http://localhost:8080/api/registration/request/self/' + token, {
            method: "GET",
            headers: {
                "Authorization": "Bearer " + token,
                "Content-Type": "application/json",
            },
        })
            .then(response => response.json())
            .then(data => {
                setMembershipRequest(data);

                fetch("http://localhost:8080/api/registration/upload-work-form", {
                    method: "GET",
                    headers: {
                        "Authorization": "Bearer " + token,
                        "Content-Type": "application/json",
                    },
                })
                    .then(response => response.json())
                    .then(data => {
                        setPublishWorkForm(data);
                    })
                    .catch((error) => {
                        console.log(error);
                    });

            })
            .catch((error) => {
                console.log(error);
            });
    }, []);


    const handleFileUpload = () => {
        const token = JSON.parse(localStorage.getItem("token"));
        fetch('http://localhost:8080/api/registration/request/self/' + token, {
            method: "GET",
            headers: {
                "Authorization": "Bearer " + token,
                "Content-Type": "application/json",
            },
        })
            .then(response => response.json())
            .then(data => {
                setMembershipRequest(data);
                setPublishWorkForm(null);
                fetch("http://localhost:8080/api/registration/upload-work-form", {
                    method: "GET",
                    headers: {
                        "Authorization": "Bearer " + token,
                        "Content-Type": "application/json",
                    },
                })
                    .then(response => response.json())
                    .then(data => {
                        setPublishWorkForm(data);
                    })
                    .catch((error) => {
                        console.log(error);
                    });

            })
            .catch((error) => {
                console.log(error);
            });
    }

    return (
        <div className="bg-dark p-5">
            {/*<PreviewComments show={showComments} onHide={handleCloseComments}/>*/}
            {/*<PreviewPDF show={showDocument} onHide={handleCloseDocument}/>*/}
            {/*<Confirmation show={showConfirmation} onHide={(confirmed) => handleCloseConfirmation(confirmed)}/>*/}
            <div className="bg-dark p-5 border border-light text-left">
                {membershipRequest &&
                <>
                    <h2 className="text-light mb-4">
                        Submitted Work
                    </h2>
                    <h5 className="text-danger">
                        Submission deadline : {membershipRequest.submissionDeadline}
                    </h5>
                    <h5 className="text-warning mb-4">
                        Attempts number : {membershipRequest.attemptsNumber}
                    </h5>
                </>
                }
                {/*<Button onClick={() => handleFileChooserClick()} variant="outline-warning" className="mb-4">*/}
                {/*    SUBMIT WORK*/}
                {/*</Button>*/}
                {/*<Form>*/}
                {/*    <Form.File*/}
                {/*        multiple*/}
                {/*        accept="application/pdf"*/}
                {/*        className="hidden"*/}
                {/*        ref={hiddenFileInput}*/}
                {/*        onChange={(event) => handleFileChooserChange(event)}/>*/}
                {/*</Form>*/}
                {publishWorkForm &&
                <div hidden={membershipRequest.attemptsNumber >= 2 && membershipRequest.status === "WAITING_OPINION"}>
                    <CustomForm
                        formFieldsDTO={publishWorkForm}
                        loggedIn={localStorage.getItem("token")}
                        submittedForm={handleFileUpload}
                        isFileForm={true}
                        checkFlags={false}
                        buttons={
                            [
                                {
                                    flagIndex: 0,
                                    hasFlag: false,
                                    variant: "success",
                                    text: "Submit work"
                                }
                            ]}/>
                </div>
                }


                {/*{   submitted &&*/}
                {/*    <Table striped bordered hover variant="dark">*/}
                {/*        <thead>*/}
                {/*        <tr>*/}
                {/*            <th>#</th>*/}
                {/*            <th>Status</th>*/}
                {/*            <th></th>*/}
                {/*            <th></th>*/}
                {/*        </tr>*/}
                {/*        </thead>*/}
                {/*        <tbody>*/}
                {/*        <tr>*/}
                {/*            <td>1</td>*/}
                {/*            <td>{allReviewed ? "Reviewed" : "Not reviewed"}</td>*/}
                {/*            <td className="text-center">*/}
                {/*                <Button variant="outline-info" onClick={() => handleShowComments()}>*/}
                {/*                    PREVIEW COMMENTS*/}
                {/*                </Button>*/}
                {/*            </td>*/}
                {/*            <td className="text-center">*/}
                {/*                <Button variant="outline-light" onClick={() => handleShowDocument()}>*/}
                {/*                    PREVIEW WORK*/}
                {/*                </Button>*/}
                {/*            </td>*/}
                {/*        </tr>*/}
                {/*        <tr>*/}
                {/*            <td>2</td>*/}
                {/*            <td>Reviewed</td>*/}
                {/*            <td className="text-center">*/}
                {/*                <Button variant="outline-info">*/}
                {/*                    PREVIEW COMMENTS*/}
                {/*                </Button>*/}
                {/*            </td>*/}
                {/*            <td className="text-center">*/}
                {/*                <Button variant="outline-light">*/}
                {/*                    PREVIEW WORK*/}
                {/*                </Button>*/}
                {/*            </td>*/}
                {/*        </tr>*/}
                {/*        <tr>*/}
                {/*            <td>3</td>*/}
                {/*            <td>{allReviewed ? "Reviewed" : "Not reviewed"}</td>*/}
                {/*            <td className="text-center">*/}
                {/*                <Button variant="outline-info">*/}
                {/*                    PREVIEW COMMENTS*/}
                {/*                </Button>*/}
                {/*            </td>*/}
                {/*            <td className="text-center">*/}
                {/*                <Button variant="outline-light">*/}
                {/*                    PREVIEW WORK*/}
                {/*                </Button>*/}
                {/*            </td>*/}
                {/*        </tr>*/}
                {/*        </tbody>*/}
                {/*    </Table>*/}
                {/*}*/}
                {/*Delete testing elements from here*/}
                {/*<div className="row">*/}
                {/*    <Button onClick={() => setAllReviewed(!allReviewed)} variant="outline-danger" className="mb-3 ml-3">*/}
                {/*        CHANGE ALL REVIEWED TO {allReviewed ? "FALSE" : "TRUE"}*/}
                {/*    </Button>*/}
                {/*</div>*/}
                {/*<div className="row">*/}
                {/*    <Button onClick={() => setSubmitted(!submitted)} variant="outline-danger" className="ml-3 mb-3">*/}
                {/*        CHANGE SUBMITTED TO {submitted ? "FALSE" : "TRUE"}*/}
                {/*    </Button>*/}
                {/*</div>*/}
                {/*<div className="row">*/}
                {/*    <Button onClick={() => setAttemptsNumber(attemptsNumber - 1)} variant="outline-danger" className="ml-3">*/}
                {/*        -*/}
                {/*    </Button>*/}
                {/*    <Button variant={"outline-light"} disabled={true} className="ml-3">ATTEMPT</Button>*/}
                {/*    <Button onClick={() => setAttemptsNumber(attemptsNumber + 1)} variant="outline-danger" className="ml-3">*/}
                {/*       +*/}
                {/*    </Button>*/}
                {/*</div>*/}
                {/*End of test elements*/}
            </div>
        </div>
    );
}