import React, { useState } from 'react';
import { Document, Page } from 'react-pdf';
import {Modal} from "react-bootstrap";
import 'react-pdf/dist/esm/Page/AnnotationLayer.css';
import { pdfjs } from 'react-pdf';

pdfjs.GlobalWorkerOptions.workerSrc = `//cdnjs.cloudflare.com/ajax/libs/pdf.js/${pdfjs.version}/pdf.worker.js`;

export default function PreviewPDF(props) {
    const [numPages, setNumPages] = useState(null);
    const [pageNumber, setPageNumber] = useState(64);

    function onDocumentLoadSuccess({ numPages }) {
        setNumPages(numPages);
    }

    const handleClose = () => {
        props.onHide();
    };

    return (
        <Modal centered show={props.show} onHide={handleClose} className="preview-pdf">
            <Modal.Body className="">
                <Document
                    className="center-document mt-0 pt-0"
                    file={"../docs/Encyclopedia_of_Comic_Books_and_Graphic_Novels.pdf"}
                    onLoadSuccess={onDocumentLoadSuccess}>
                    <div className="row controls-center">
                        <i onClick={() => setPageNumber(pageNumber - 1)} className="material-icons">keyboard_arrow_left</i>
                        <p>Page {pageNumber} of {numPages}</p>
                        <i onClick={() => setPageNumber(pageNumber + 1)} className="material-icons">keyboard_arrow_right</i>
                    </div>
                    <Page className="mb-3" pageNumber={pageNumber} />
                    <div className="row controls-center">
                        <i onClick={() => setPageNumber(pageNumber - 1)} className="material-icons">keyboard_arrow_left</i>
                        <p>Page {pageNumber} of {numPages}</p>
                        <i onClick={() => setPageNumber(pageNumber + 1)} className="material-icons">keyboard_arrow_right</i>
                    </div>
                </Document>
            </Modal.Body>
        </Modal>
    );
}