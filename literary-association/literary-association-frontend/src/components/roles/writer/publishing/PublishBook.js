import React, {useState} from "react";
import Confirmation from "../../../core/modals/Confirmation";
import {Button, ButtonGroup, Form, Table} from "react-bootstrap";
import Select from "react-select";

export default function PublishBook(){

    const genres = [
        { value: "fantasy", label: "Fantasy" },
        { value: "romance", label: "Romance" },
        { value: "thriller", label: "Thriller" }
    ];

    const [status, setStatus] = useState("");

    const [submitted, setSubmitted] = useState(false)

    const [showConfirmation, setShowConfirmation] = useState(false);

    const [files, setFiles] = useState([]);

    const hiddenFileInput = React.useRef(null);

    const handleCloseConfirmation = (confirmed) => {
        if(confirmed) {
            setSubmitted(true);
            switch (status) {
                case "WAITING_SUBMIT": {setStatus("WAITING_PLAGIARISM_CHECK");break;}
                case "WAITING_COMMENT_CHECK": {setStatus("WAITING_SUGGESTIONS");break;}
                case "WAITING_CHANGES": {setStatus("WAITING_SUGGESTIONS");break;}
                case "WAITING_CORRECTIONS" : {setStatus("WAITING_LECTOR_REVIEW");break;}
                case "WAITING_LECTOR_REVIEW" : {setStatus("WAITING_SUGGESTIONS");break;}
            }
        }
        else {
            hiddenFileInput.current.value = "";
        }
        setShowConfirmation(false);
    }
    const handleShowConfirmation = () => setShowConfirmation(true);

    const handleFileChooserChange = (event) => {
        const newFiles = event.target.files;
        setFiles(newFiles);
        handleFileChooserClose();
    };

    const handleFileChooserClick = () => {
        hiddenFileInput.current.click();
    };

    const handleFileChooserClose = () => {
        handleShowConfirmation();
    };

    const renderStatus = (status) => {
        switch (status) {
            case "WAITING_PLAGIARISM_CHECK" :
                return (
                    <h5 className="text-danger mb-3">
                        Waiting for plagiarism check ...
                    </h5>
                )
            case "WAITING_READING" :
                return (
                    <>
                        <h5 className="text-success mb-3">
                            Your script has passed plagiarism check!
                        </h5>
                        <h5 className="text-danger mb-3">
                            Waiting for editor reading ...
                        </h5>
                    </>
                )
            case "WAITING_BETA_READERS" :
                return (
                    <>
                        <h5 className="text-success mb-3">
                            Your script has been read!
                        </h5>
                        <h5 className="text-danger mb-3">
                            Waiting for beta readers to comment ...
                        </h5>
                    </>
                )
            case "WAITING_LECTOR_REVIEW" :
                return (
                    <>
                        <h5 className="text-success mb-3">
                            Almost there...
                        </h5>
                        <h5 className="text-danger mb-3">
                            Waiting for lector review ...
                        </h5>
                    </>
                )
            case "WAITING_SUGGESTIONS" :
                return (
                    <>
                        <h5 className="text-danger mb-3">
                            Waiting for editor suggestions ...
                        </h5>
                    </>
                )
            case "WAITING_CORRECTIONS" :
                return (
                    <>
                        <h5 className="text-danger mb-3">
                            Please correct capital letter on "united states"!
                        </h5>
                    </>
                )
            case "WAITING_CHANGES" :
                return (
                    <>
                        <h5 className="text-danger mb-3">
                            You should change conclusion to be more specific.
                        </h5>
                    </>
                )
            case "WAITING_COMMENT_CHECK" :
                return (
                    <>
                        <Table striped bordered hover variant="dark">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Comment</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>1</td>
                                <td>
                                    It's gonna take a lot to take me away from you There's nothing that a hundred men or
                                    more could ever do I bless the rains down in Africa Gonna take some time to do the
                                    things we never have.
                                </td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>
                                    You can find me in the club, bottle full of bub Look mami I got the X if you into
                                    taking drugs I'm into having sex, I ain't into makin love So come give me a hug if
                                    you into getting rubbed.
                                </td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>
                                    Don't want to close my eyes I don't want to fall asleep Cause I'd miss you babe And
                                    I don't want to miss a thing Cause even when I dream of you The sweetest dream will
                                    never do I'd still miss you babe And I don't want to miss a thing.
                                </td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>
                                    I see trees of green........ red roses too I see em bloom..... for me and for you
                                    And I think to myself.... what a wonderful world.
                                </td>
                            </tr>
                            <tr>
                                <td>5</td>
                                <td>
                                    Buddy you're a young man hard man Shoutin' in the street gonna take on the world
                                    some day You got blood on yo' face You big disgrace Wavin' your banner all over the
                                    place.
                                </td>
                            </tr>
                            </tbody>
                        </Table>
                    </>
                )
            case "DONE" :
                return (
                    <>
                        <h5 className="text-success mb-3">
                            All good, your book is sent to printing!
                        </h5>
                    </>
                )
        }
    }

        return (
        <div className="bg-dark p-5">
            <Confirmation show={showConfirmation} onHide={(confirmed) => handleCloseConfirmation(confirmed)}/>
            <div className="bg-dark p-5 border border-light text-left text-light">
                <h2 className="text-light mb-4">
                    Publish book
                </h2>
                {   !status &&
                    <Form className="mt-5 mb-5 w-25">
                        <Form.Group controlId="email" className="text-left">
                            <Form.Label>Title</Form.Label>
                            <Form.Control type="Title" placeholder="Enter Title"/>
                        </Form.Group>
                        <Form.Group controlId="genres" className="text-left">
                            <Form.Label>Genre</Form.Label>
                            <Select className="text-dark" options={genres}/>
                        </Form.Group>
                        <Form.Group controlId="synopsys" className="text-left">
                            <Form.Label>Synopsys</Form.Label>
                            <Form.Control as="textarea" rows={5} placeholder="Synopsys"/>
                        </Form.Group>
                        <Button variant="outline-success" type="" onClick={() => setStatus("WAITING_SUBMIT")}
                                className="mt-3">
                            SEND REQUEST
                        </Button>
                    </Form>
                }
                {status &&
                    <>
                        <h5 className="text-light mb-3">
                            Title : Hello world
                        </h5>
                        <h5 className="text-light mb-3">
                            Genre : Romance
                        </h5>
                        <h5 className="text-light mb-3 w-25 text-justify">
                            Synopsys : Look! In the sky. It's a bird, it's a plane. Or is it a hellicopter? No actually I think it is a bird. Or maybe I'm just seeing things. Who knows... After 10 shots of Whiskey things start to get a bit strange.
                        </h5>
                    </>
                }
                {   (status === "WAITING_SUBMIT" || status === "WAITING_COMMENT_CHECK" || status === "WAITING_CORRECTIONS" || status === "WAITING_CHANGES") &&
                    <>
                        {   (status === "WAITING_SUBMIT" || status === "WAITING_COMMENT_CHECK" || status === "WAITING_CORRECTIONS") &&
                            <h5 className="text-danger mb-3">
                                Submission deadline : 31.12.2020.
                            </h5>
                        }
                        {   status === "WAITING_CHANGES" &&
                            <h5 className="text-danger mb-3">
                                Changes deadline : 15.1.2021.
                            </h5>
                        }
                        <Button onClick={() => handleFileChooserClick()} disabled={submitted} variant="outline-warning" className="mb-4">
                        SUBMIT WORK
                        </Button>
                        <Form>
                            <Form.File
                            accept="application/pdf"
                            className="hidden"
                            ref={hiddenFileInput}
                            onChange={(event) => handleFileChooserChange(event)}/>
                        </Form>
                    </>
                }
                {renderStatus(status)}
                {/*Delete testing elements from here*/}
                <div className="row ml-1">
                    <ButtonGroup>
                        <Button variant="outline-info" onClick={() => setStatus("WAITING_READING")}>
                            PLAGIARISM CHECK PASSED
                        </Button>
                        <Button variant="outline-warning" onClick={() => {
                            setStatus("WAITING_BETA_READERS");}}>
                            EDITOR READ SCRIPT
                        </Button>
                        <Button variant="outline-danger" onClick={() => {
                            setSubmitted(false);
                            setStatus("WAITING_COMMENT_CHECK")}}>
                            BETA READERS COMMENTED
                        </Button>
                        <Button variant="outline-light" onClick={() => {
                            setSubmitted(false);
                            setStatus("WAITING_CORRECTIONS")}}>
                            LECTOR REVIEWED
                        </Button>
                        <Button variant="outline-info" onClick={() => {
                            setSubmitted(false);
                            setStatus("WAITING_SUGGESTIONS")}}>
                            LECTOR APPROVED
                        </Button>
                        <Button variant="outline-danger" onClick={() => {
                            setSubmitted(false);
                            setStatus("WAITING_LECTOR_REVIEW")
                        }}>
                            EDITOR SEND TO LECTOR
                        </Button>
                        <Button variant="outline-success" onClick={() => {
                            setSubmitted(false);
                            setStatus("WAITING_CHANGES")
                        }}>
                            EDITOR SUGGESTED
                        </Button>
                        <Button variant="outline-primary" onClick={() => {
                            setStatus("DONE")
                        }}>
                            EDITOR FINALLY APPROVED
                        </Button>
                    </ButtonGroup>
                </div>
                {/*End of test elements*/}
            </div>
        </div>
    );
}