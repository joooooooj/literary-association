import React, {useState} from "react";
import {Button, Table, ButtonGroup} from "react-bootstrap";
import PreviewPDF from "../../core/modals/PreviewPDF";
import AddCorrections from "./AddCorrections";

export default function CorrectionsScripts() {

    const [status, setStatus] = useState("WAITING_LECTOR_REVIEW");

    const [showDocument, setShowDocument] = useState(false);
    const [showCorrections, setShowCorrections] = useState(false);

    const handleCloseDocument = () => setShowDocument(false);
    const handleShowDocument = () => setShowDocument(true);

    const handleCloseCorrections = () => setShowCorrections(false);
    const handleShowCorrections = () => setShowCorrections(true);

    const renderStatus = () => {
        switch (status) {
            case "WAITING_LECTOR_REVIEW" : return (
                <>
                    <ButtonGroup>
                        <Button variant="outline-warning" onClick={() => handleShowCorrections()}>
                            ADD CORRECTIONS
                        </Button>
                        <Button variant="outline-success" onClick={() => ""}>
                            SEND TO EDITOR
                        </Button>
                    </ButtonGroup>
                </>
            );
            case "WAITING_CORRECTIONS" : return (
                <>
                    <h5 className="text-warning text-left">
                        Writer is still correcting script...
                    </h5>
                </>
            );
        }
    }

    return (
        <div className="bg-dark p-5">
            <PreviewPDF show={showDocument} onHide={handleCloseDocument}/>
            <AddCorrections show={showCorrections} onHide={handleCloseCorrections} setStatus={setStatus}/>
            <div className="bg-dark p-5 border border-light">
                <h2 className="text-left text-light mb-4">
                    Correction requests
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
                            <Button variant="outline-info" onClick={() => handleShowDocument()}>
                                READ SCRIPT
                            </Button>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Moris</td>
                        <td>Jackson</td>
                        <td>Flowers</td>
                        <td>Fantasy</td>
                        <td>
                            Life is full of temporary situations, ultimately ending in a permanent solution.
                        </td>
                        <td className="text-center" style={{verticalAlign:"middle"}}>
                            <ButtonGroup>
                                <Button variant="outline-warning" onClick={() => handleShowCorrections()}>
                                    ADD CORRECTIONS
                                </Button>
                                <Button variant="outline-success" onClick={() => ""}>
                                    SEND TO EDITOR
                                </Button>
                            </ButtonGroup>
                        </td>
                        <td className="text-center" style={{verticalAlign:"middle"}}>
                            <Button variant="outline-info" onClick={() => handleShowDocument()}>
                                READ SCRIPT
                            </Button>
                        </td>
                    </tr>
                    </tbody>
                </Table>
                {/*Delete testing elements from here*/}
                <div className="row ml-1 mt-5">
                    <ButtonGroup>
                        <Button variant="outline-info" onClick={() => setStatus("WAITING_LECTOR_REVIEW")}>
                            WRITER CORRECTED
                        </Button>
                    </ButtonGroup>
                </div>
                {/*End of test elements*/}
            </div>
        </div>
    );
}