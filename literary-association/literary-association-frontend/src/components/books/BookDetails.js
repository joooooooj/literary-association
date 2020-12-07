import React, {useState} from "react";
import {Button, Card, Modal} from "react-bootstrap";
import {Link} from "react-router-dom";

export default function BookDetails(props) {

    const handleClose = () => {
        props.onHide();
    };

    return (
        <Modal centered show={props.show} onHide={handleClose} className="w-100">
            <Modal.Body>
                <Card className="row border-0">
                    <Card.Header className="col-6 border-0">
                        <Card.Img variant="top" src={"../images/books/1.jpg"} />
                    </Card.Header>
                    <div className="col-6">
                        <Card.Body className="border-0">
                            <Card.Title>THE LAST KINDGDOM</Card.Title>
                            <Card.Subtitle className="mb-2 text-muted">FANTASY</Card.Subtitle>
                            <Card.Subtitle className="mb-2 text-muted">ISBN : 978147321791</Card.Subtitle>
                            <Card.Text className="mb-0 font-weight-bold">Writer : Bernard Cornwell</Card.Text>
                            <Card.Text className="font-weight-bold">Publisher : HARPERCOLLINS</Card.Text>
                            <Card.Text className="book-synopsys text-justify">
                                The first book in the epic and bestselling series that has gripped millions.
                                A hero will be forged from this broken land.
                                As seen on Netflix and BBC around the world.
                                In a land torn apart by conflict, an orphan boy has come of age. Raised by the Vikings, deadly enemies of his own Saxon people, Uhtred is a fierce and skilled warrior who kneels to no-one.
                                The first book in the epic and bestselling series that has gripped millions.
                                A hero will be forged from this broken land.
                                As seen on Netflix and BBC around the world.
                                The first book in the epic and bestselling series that has gripped millions.
                                A hero will be forged from this broken land.
                                As seen on Netflix and BBC around the world.
                                The first book in the epic and bestselling series that has gripped millions.
                                A hero will be forged from this broken land.
                                As seen on Netflix and BBC around the world.
                                The first book in the epic and bestselling series that has gripped millions.
                                A hero will be forged from this broken land.
                                As seen on Netflix and BBC around the world.
                                The first book in the epic and bestselling series that has gripped millions.
                                A hero will be forged from this broken land.
                                As seen on Netflix and BBC around the world.
                                The first book in the epic and bestselling series that has gripped millions.
                                A hero will be forged from this broken land.
                                As seen on Netflix and BBC around the world.
                                The first book in the epic and bestselling series that has gripped millions.
                                A hero will be forged from this broken land.
                                As seen on Netflix and BBC around the world.
                            </Card.Text>
                            <Card.Text className="font-weight-bold">
                                <Link to="/pricing">
                                    <div className="row ml-1">
                                        <i className="material-icons">get_app</i>
                                        DOWNLOAD BOOK
                                    </div>
                                </Link>
                            </Card.Text>
                        </Card.Body>
                        <Card.Footer className="ml-3">
                            <div className="row row-cols-1 mt-3">
                                <h3 className="text-danger mb-5">10 $</h3>
                            </div>
                            <div className="row">
                                <Button variant="outline-dark" className="col-1 add-remove-button">
                                    <i className="material-icons">remove</i>
                                </Button>
                                <input className="w-25 col-2" defaultValue="1"/>
                                <Button variant="outline-dark" className="col-1 mr-2 add-remove-button">
                                    <i className="material-icons">add</i>
                                </Button>
                                <Button variant="success" className="col-6 ml-5 float-right cart-button">
                                    ADD TO CART
                                    <i className="material-icons ml-3">shopping_cart</i>
                                </Button>
                            </div>
                        </Card.Footer>
                    </div>
                </Card>
            </Modal.Body>
        </Modal>
    );
}