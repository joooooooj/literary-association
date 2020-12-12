import React, {useState} from "react";
import {Button, Table} from "react-bootstrap";
import PreviewPDF from "../../core/modals/PreviewPDF";
import AddComment from "./AddComment";

export default function CommentsScripts() {

    const [showDocument, setShowDocument] = useState(false);
    const [showComment, setShowComment] = useState(false);

    const handleCloseDocument = () => setShowDocument(false);
    const handleShowDocument = () => setShowDocument(true);

    const handleCloseComment = () => setShowComment(false);
    const handleShowComment = () => setShowComment(true);

    return (
        <div className="bg-dark p-5">
            <PreviewPDF show={showDocument} onHide={handleCloseDocument}/>
            <AddComment show={showComment} onHide={handleCloseComment}/>
            <div className="bg-dark p-5 border border-light">
                <h2 className="text-left text-light mb-4">
                    Review scripts
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
                        <th>Deadline</th>
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
                        <td className="text-center text-danger" style={{verticalAlign:"middle"}}>
                            15.1.2021.
                        </td>
                        <td className="text-center" style={{verticalAlign:"middle"}}>
                            <Button variant="outline-warning" onClick={() => handleShowComment()}>
                                ADD COMMENT
                            </Button>
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
                        <td className="text-center text-danger" style={{verticalAlign:"middle"}}>
                            20.1.2021.
                        </td>
                        <td className="text-center" style={{verticalAlign:"middle"}}>
                            <Button variant="outline-warning" onClick={() => handleShowComment()}>
                                ADD COMMENT
                            </Button>
                        </td>
                        <td className="text-center" style={{verticalAlign:"middle"}}>
                            <Button variant="outline-info" onClick={() => handleShowDocument()}>
                                READ SCRIPT
                            </Button>
                        </td>
                    </tr>
                    </tbody>
                </Table>
            </div>
        </div>
    );
}