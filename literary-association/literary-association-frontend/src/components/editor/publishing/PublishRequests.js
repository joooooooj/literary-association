import React, {useState} from "react";
import {Button, ButtonGroup, Table} from "react-bootstrap";
import Confirmation from "../../core/modals/Confirmation";
import AddExplanation from "./AddExplanation";
import PlagiarismCheckResults from "./PlagiarismCheckResults";
import PreviewPDF from "../../core/modals/PreviewPDF";
import ChooseBetaReaders from "./ChooseBetaReaders";
import AddSuggestions from "./AddSuggestions";

export default function PublishRequests() {

    const [status, setStatus] = useState("");
    const [corrections, setCorrections] = useState(null);

    const [showExplanation, setShowExplanation] = useState(false);
    const [showSuggestions, setShowSuggestions] = useState(false);
    const [showBetaReaders, setShowBetaReaders] = useState(false);
    const [showPlagiarismCheckResults, setShowPlagiarismCheckResults] = useState(false);
    const [showDocument, setShowDocument] = useState(false);

    const handleShowExplanation = () => setShowExplanation(true);
    const handleCloseExplanation = () => setShowExplanation(false);

    const handleShowSuggestions = () => setShowSuggestions(true);
    const handleCloseSuggestions = () => setShowSuggestions(false);

    const handleShowPlagiarismCheckResults = () => setShowPlagiarismCheckResults(true);
    const handleClosePlagiarismCheckResults = () => setShowPlagiarismCheckResults(false);

    const handleCloseDocument = () => setShowDocument(false);
    const handleShowDocument = () => setShowDocument(true);

    const handleCloseBetaReaders = () => setShowBetaReaders(false);
    const handleShowBetaReaders = () => setShowBetaReaders(true);

    const renderStatus = (status) => {
        switch (status) {
            case "WAITING_SUBMIT" : {
                return (
                    <>
                        <h5 className="text-warning text-left">
                            Waiting for reader to submit script...
                            Submission deadline : 15.1.2021.
                        </h5>
                    </>
                );
            }
            case "WAITING_PLAGIARISM_CHECK" : {
                return (
                    <>
                        <Button variant="outline-info" onClick={() => handleShowPlagiarismCheckResults()}>
                            PREVIEW PLAGIARISM CHECK RESULTS
                        </Button>
                    </>
                );
            }
            case "WAITING_READING" : {
                return (
                    <>
                        <Button variant="outline-success" onClick={() => handleShowDocument()}>
                            READ SCRIPT
                        </Button>
                    </>
                );
            }
            case "WAITING_AFTER_READING" : {
                return (
                    <>
                        <ButtonGroup>
                            <Button variant="outline-info" onClick={() => handleShowBetaReaders()}>
                                SEND TO BETA READERS
                            </Button>
                            <Button variant="outline-warning" onClick={() => setStatus("WAITING_LECTOR_REVIEW")}>
                                SEND TO LECTOR
                            </Button>
                        </ButtonGroup>
                    </>
                );
            }
            case "WAITING_BETA_READERS": {
                return (
                    <>
                        <h5 className="text-warning text-left">
                            Waiting for beta readers to comment...
                            Comments deadline : 15.1.2021.
                        </h5>
                    </>
                );
            }
            case "WAITING_COMMENT_CHECK": {
                return (
                    <>
                        <h5 className="text-warning text-left">
                            Writer is reviewing comments...
                        </h5>
                    </>
                );
            }
            case "WAITING_LECTOR_REVIEW": {
                return (
                    <>
                        <h5 className="text-warning text-left">
                            Waiting lector review...
                        </h5>
                    </>
                );
            }
            case "WAITING_CORRECTIONS": {
                return (
                    <>
                        <h5 className="text-warning text-left">
                            Writer is still correcting script...
                        </h5>
                    </>
                );
            }
            case "WAITING_CHANGES": {
                return (
                    <>
                        <h5 className="text-warning text-left">
                            Writer is still changing script...
                            {   corrections &&
                               <> Changes deadline : 15.1.2021.</>
                            }
                        </h5>
                    </>
                );
            }
            case "WAITING_SUGGESTIONS": {
                return (
                    <>
                        <ButtonGroup>
                            {   corrections &&
                            <Button variant="outline-success" onClick={() => setStatus("DONE")}>
                                SEND TO PRINTING
                            </Button>
                            }
                            {   !corrections &&
                            <Button variant="outline-success" onClick={() => setStatus("WAITING_LECTOR_REVIEW")}>
                                SEND TO LECTOR
                            </Button>
                            }
                            <Button variant="outline-danger" onClick={() => handleShowSuggestions()}>
                                GIVE SUGGESTION
                            </Button>
                        </ButtonGroup>
                    </>
                );
            }
            case "DONE": {
                return (
                    <>
                        <h5 className="text-success text-left">
                           ALL DONE
                        </h5>
                    </>
                );
            }
            default: {
                return (
                <ButtonGroup>
                    <Button variant="outline-success" onClick={() => setStatus("WAITING_SUBMIT")}>
                        APPROVE
                    </Button>
                    <Button variant="outline-danger" onClick={() => handleShowExplanation()}>
                        REJECT
                    </Button>
                </ButtonGroup>
                );
            }
        }
    }

    return (
        <div className="bg-dark p-5">
            <AddExplanation show={showExplanation} onHide={handleCloseExplanation} setStatus={setStatus}/>
            <AddSuggestions show={showSuggestions} onHide={handleCloseSuggestions} setStatus={setStatus}/>
            <ChooseBetaReaders show={showBetaReaders} onHide={handleCloseBetaReaders} setStatus={setStatus}/>
            <PlagiarismCheckResults show={showPlagiarismCheckResults} onHide={handleClosePlagiarismCheckResults} setStatus={setStatus} handleShowExplanation={handleShowExplanation}/>
            <PreviewPDF show={showDocument} onHide={handleCloseDocument} status={status} setStatus={setStatus} handleShowExplanation={handleShowExplanation}/>
            <div className="bg-dark p-5 border border-light">
                <h2 className="text-left text-light mb-4">
                    Publish requests
                </h2>
                <Table striped bordered hover variant="dark">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Title</th>
                        <th>Genre</th>
                        <th className="w-25">Synopsys</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>Neil</td>
                        <td>Gaiman</td>
                        <td>Hello world</td>
                        <td>Romance</td>
                        <td>
                            Look! In the sky. It's a bird, it's a plane.
                            Or is it a hellicopter? No actually I think it is a bird.
                            Or maybe I'm just seeing things. Who knows...
                            After 10 shots of Whiskey things start to get a bit strange.
                        </td>
                        <td className="text-center" style={{verticalAlign:"middle"}}>
                            {renderStatus(status)}
                        </td>
                        <td className="text-center" style={{verticalAlign:"middle"}}>
                            {status === "WAITING_SUGGESTIONS" &&
                                <Button variant="outline-info" onClick={() => handleShowDocument()}>
                                    READ SCRIPT
                                </Button>
                            }
                        </td>
                    </tr>
                    </tbody>
                </Table>
                {/*Delete testing elements from here*/}
                <div className="row ml-1 mt-5">
                    <ButtonGroup>
                        <Button variant="outline-info" onClick={() => setStatus("WAITING_PLAGIARISM_CHECK")}>
                            WRITER SUBMIT
                        </Button>
                    </ButtonGroup>
                </div>
                <div className="row ml-1 mt-5">
                    <ButtonGroup>
                        <Button variant="outline-danger" onClick={() => setStatus("WAITING_COMMENT_CHECK")}>
                            BETA READERS COMMENTED
                        </Button>
                        <Button variant="outline-light" onClick={() => setStatus("WAITING_SUGGESTIONS")}>
                            WRITER REVIEWED COMMENTS
                        </Button>
                    </ButtonGroup>
                </div>
                <div className="row ml-1 mt-5">
                    <ButtonGroup>
                        <Button variant="outline-warning" onClick={() => setStatus("WAITING_CORRECTIONS")}>
                            LECTOR REVIEWED
                        </Button>
                        <Button variant="outline-info" onClick={() => setStatus("WAITING_LECTOR_REVIEW")}>
                            WRITER CORRECTED SCRIPT
                        </Button>
                        <Button variant="outline-danger" onClick={() =>
                                                                    {setCorrections("No corrections");
                                                                    setStatus("WAITING_SUGGESTIONS");}}>
                            LECTOR APPROVED
                        </Button>
                    </ButtonGroup>
                </div>
                <div className="row ml-1 mt-5">
                    <ButtonGroup>
                        <Button variant="outline-light" onClick={() => setStatus("WAITING_SUGGESTIONS")}>
                            WRITER CHANGED
                        </Button>
                    </ButtonGroup>
                </div>
                {/*End of test elements*/}
            </div>
        </div>
    );
}