import React, {useEffect, useState} from "react";
import Confirmation from "../../../core/modals/Confirmation";
import {Button, ButtonGroup, Form, Table} from "react-bootstrap";
import Select from "react-select";
import {useForm} from "react-hook-form";
import CustomFormField from "../../../core/CustomFormField";

export default function PublishBook(props){

    const [publishBookForm, setPublishBookForm] = useState(null);

    const [requestInfo, setRequestInfo] = useState(null);

    // REACT-HOOK-FORM
    const {register, errors, handleSubmit} = useForm();
    const onSubmit = (data) => {
        let final = prepareDataForSubmit(data);
        fetch("http://localhost:8080/publish/writer/form/" + publishBookForm.taskId, {
            method: "POST",
            headers: {
                "Authorization" : "Bearer " + props.loggedIn,
                "Content-Type": "application/json",
            },
            body: JSON.stringify(final)
        })
            .then(response => response)
            .then(data => {
                setPublishBookForm(null);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    const [status, setStatus] = useState("");

    const [submitted, setSubmitted] = useState(false)

    const [showConfirmation, setShowConfirmation] = useState(false);

    const [files, setFiles] = useState([]);

    const hiddenFileInput = React.useRef(null);

    useEffect (() =>{
        fetch("http://localhost:8080/publish/writer/form/" + props.loggedIn, {
            method: "GET",
            headers: {
                "Authorization" : "Bearer " + props.loggedIn,
                "Content-Type": "application/json",
            },
        })
            .then(response => response.json())
            .then(data => {
                if (data.formFields){
                    setPublishBookForm(data);
                }
                else {
                    handleRequestInfo();
                }
            })
            .catch((error) => {
                console.log(error);
            });
    }, [])

    const handleRequestInfo = () => {
        fetch("http://localhost:8080/publish/writer/status/" + props.loggedIn, {
            method: "GET",
            headers: {
                "Authorization" : "Bearer " + props.loggedIn,
                "Content-Type": "application/json",
            },
        })
            .then(response => response.json())
            .then(data => {
               setRequestInfo(data);
                if (data.status){
                    setStatus(data.status);
                }
                else {
                    setStatus("NO STATUS");
                }
               console.log(data);
            })
            .catch((error) => {
                console.log(error);
            });
    }

    const prepareDataForSubmit = (data) => {
        let final = [];
        for(let prop in data){
            final.push({fieldId:prop, fieldValue:data[prop]})
        }
        return final;
    }

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
                {!status && !publishBookForm &&
                    <>
                        <h5 className="text-warning mt-3 mb-3">
                            Please reload page for more info ...
                        </h5>
                    </>
                }
                {   !status && publishBookForm &&
                    <Form className="mt-5 mb-5 w-25" onSubmit={handleSubmit(onSubmit)}>
                        {publishBookForm.formFields.map((formField) => {
                            return (
                                <CustomFormField formField={formField} errors={errors} register={register}/>
                            )
                            })
                        }
                        <Button variant="outline-success" type="submit"
                                className="mt-3">
                            SEND REQUEST
                        </Button>
                    </Form>
                }
                {status &&
                    <>
                        <h5 className="text-light mb-3">
                            Title : {requestInfo.title}
                        </h5>
                        <h5 className="text-light mb-3">
                            Genre : {requestInfo.genre}
                        </h5>
                        <h5 className="text-light mb-3 w-25 text-justify">
                            Synopsis : {requestInfo.synopsis}
                        </h5>
                        <h5 className="text-warning mt-3 mb-3">
                            Main editor is reviewing your request ...
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
                {/*/!*Delete testing elements from here*!/*/}
                {/*<div className="row ml-1">*/}
                {/*    <ButtonGroup>*/}
                {/*        <Button variant="outline-info" onClick={() => setStatus("WAITING_READING")}>*/}
                {/*            PLAGIARISM CHECK PASSED*/}
                {/*        </Button>*/}
                {/*        <Button variant="outline-warning" onClick={() => {*/}
                {/*            setStatus("WAITING_BETA_READERS");}}>*/}
                {/*            EDITOR READ SCRIPT*/}
                {/*        </Button>*/}
                {/*        <Button variant="outline-danger" onClick={() => {*/}
                {/*            setSubmitted(false);*/}
                {/*            setStatus("WAITING_COMMENT_CHECK")}}>*/}
                {/*            BETA READERS COMMENTED*/}
                {/*        </Button>*/}
                {/*        <Button variant="outline-light" onClick={() => {*/}
                {/*            setSubmitted(false);*/}
                {/*            setStatus("WAITING_CORRECTIONS")}}>*/}
                {/*            LECTOR REVIEWED*/}
                {/*        </Button>*/}
                {/*        <Button variant="outline-info" onClick={() => {*/}
                {/*            setSubmitted(false);*/}
                {/*            setStatus("WAITING_SUGGESTIONS")}}>*/}
                {/*            LECTOR APPROVED*/}
                {/*        </Button>*/}
                {/*        <Button variant="outline-danger" onClick={() => {*/}
                {/*            setSubmitted(false);*/}
                {/*            setStatus("WAITING_LECTOR_REVIEW")*/}
                {/*        }}>*/}
                {/*            EDITOR SEND TO LECTOR*/}
                {/*        </Button>*/}
                {/*        <Button variant="outline-success" onClick={() => {*/}
                {/*            setSubmitted(false);*/}
                {/*            setStatus("WAITING_CHANGES")*/}
                {/*        }}>*/}
                {/*            EDITOR SUGGESTED*/}
                {/*        </Button>*/}
                {/*        <Button variant="outline-primary" onClick={() => {*/}
                {/*            setStatus("DONE")*/}
                {/*        }}>*/}
                {/*            EDITOR FINALLY APPROVED*/}
                {/*        </Button>*/}
                {/*    </ButtonGroup>*/}
                {/*</div>*/}
                {/*/!*End of test elements*!/*/}
            </div>
        </div>
    );
}