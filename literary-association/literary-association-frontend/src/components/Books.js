import React, {useState} from "react";
import {Card, Button} from "react-bootstrap";
import BookDetails from "./BookDetails";
import BookSearch from "./BookSearch";

export default function Books() {

    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    return (
        <div className="row">
            <BookDetails show={show} onHide={handleClose}/>
            <div className="col-3">
                <BookSearch/>
            </div>
            <div className="books-preview col-9 row row-cols-4 text-center">
                <Card className="">
                    <Card.Header>
                        <Card.Img variant="top" src={"../images/books/1.jpg"} />
                    </Card.Header>
                    <Card.Body>
                        <Card.Title>THE LAST KINDGDOM</Card.Title>
                        <Card.Text className="mb-0 font-weight-bold">Autor : Bernard Cornwell</Card.Text>
                    </Card.Body>
                    <Card.Footer>
                            <h3 className="text-danger mb-5">10 $</h3>
                            <Button variant="outline-danger" className="w-100" onClick={handleShow}>
                                SHOW MORE DETAILS
                            </Button>
                    </Card.Footer>
                </Card>
                <Card>
                    <Card.Header>
                        <Card.Img variant="top" src={"../images/books/2.jpg"} />
                    </Card.Header>
                    <Card.Body>
                        <Card.Title>CITY OF GIRLS</Card.Title>
                        <Card.Text className="mb-0 font-weight-bold">Autor : Elizabeth Gilbert</Card.Text>
                    </Card.Body>
                    <Card.Footer>
                        <h3 className="text-danger mb-5">10 $</h3>
                        <Button variant="outline-danger" className="w-100">
                            SHOW MORE DETAILS
                        </Button>
                    </Card.Footer>
                </Card>
                <Card>
                    <Card.Header>
                        <Card.Img variant="top" src={"../images/books/3.jpg"} />
                    </Card.Header>
                    <Card.Body>
                        <Card.Title>THE BOY FROM THE WOODS</Card.Title>
                        <Card.Text className="mb-0 font-weight-bold">Autor : Harlan Coben</Card.Text>
                    </Card.Body>
                    <Card.Footer>
                        <h3 className="text-danger mb-5">10 $</h3>
                        <Button variant="outline-danger" className="w-100">
                            SHOW MORE DETAILS
                        </Button>
                    </Card.Footer>
                </Card>
                <Card>
                    <Card.Header>
                        <Card.Img variant="top" src={"../images/books/4.jpg"} />
                    </Card.Header>
                    <Card.Body>
                        <Card.Title>CONFESSIONS OF AN ENGLISH OPIUM EATER</Card.Title>
                        <Card.Text className="mb-0 font-weight-bold">Autor : Thomas de Quincey</Card.Text>
                    </Card.Body>
                    <Card.Footer>
                        <h3 className="text-danger mb-5">10 $</h3>
                        <Button variant="outline-danger" className="w-100">
                            SHOW MORE DETAILS
                        </Button>
                    </Card.Footer>
                </Card>
                <Card>
                    <Card.Header>
                        <Card.Img variant="top" src={"../images/books/5.jpg"}  className=""/>
                    </Card.Header>
                    <Card.Body>
                        <Card.Title>RITA HAYWORTH AND SHAWSHANK REDEMPTION</Card.Title>
                        <Card.Text className="mb-0 font-weight-bold">Autor : Stephen King</Card.Text>
                    </Card.Body>
                    <Card.Footer>
                        <h3 className="text-danger mb-5">10 $</h3>
                        <Button variant="outline-danger" className="w-100">
                            SHOW MORE DETAILS
                        </Button>
                    </Card.Footer>
                </Card>
                <Card>
                    <Card.Header>
                        <Card.Img variant="top" src={"../images/books/6.jpg"} />
                    </Card.Header>
                    <Card.Body>
                        <Card.Title>EDGAR ALLAN POE PUZZLE COLLECTION</Card.Title>
                        <Card.Text className="mb-0 font-weight-bold">Autor : Jason Ward</Card.Text>
                    </Card.Body>
                    <Card.Footer>
                        <h3 className="text-danger mb-5">10 $</h3>
                        <Button variant="outline-danger" className="w-100">
                            SHOW MORE DETAILS
                        </Button>
                    </Card.Footer>
                </Card>
                <Card>
                    <Card.Header>
                        <Card.Img variant="top" src={"../images/books/7.jpg"} />
                    </Card.Header>
                    <Card.Body>
                        <Card.Title>STARSIGHT</Card.Title>
                        <Card.Text className="mb-0 font-weight-bold">Autor : Brandon Sanderson</Card.Text>
                    </Card.Body>
                    <Card.Footer>
                        <h3 className="text-danger mb-5">10 $</h3>
                        <Button variant="outline-danger" className="w-100">
                            SHOW MORE DETAILS
                        </Button>
                    </Card.Footer>
                </Card>
                <Card>
                    <Card.Header>
                        <Card.Img variant="top" src={"../images/books/8.jpg"} />
                    </Card.Header>
                    <Card.Body>
                        <Card.Title>MAYAS NOTEBOOK</Card.Title>
                        <Card.Text className="mb-0 font-weight-bold">Autor : Isabel Allende</Card.Text>
                    </Card.Body>
                    <Card.Footer>
                        <h3 className="text-danger mb-5">10 $</h3>
                        <Button variant="outline-danger" className="w-100">
                            SHOW MORE DETAILS
                        </Button>
                    </Card.Footer>
                </Card>
                <Card>
                    <Card.Header>
                        <Card.Img variant="top" src={"../images/books/9.jpg"} />
                    </Card.Header>
                    <Card.Body>
                        <Card.Title>STOUNHENGE</Card.Title>
                        <Card.Text className="mb-0 font-weight-bold">Autor : Bernard Cornwell</Card.Text>
                    </Card.Body>
                    <Card.Footer>
                        <h3 className="text-danger mb-5">10 $</h3>
                        <Button variant="outline-danger" className="w-100">
                            SHOW MORE DETAILS
                        </Button>
                    </Card.Footer>
                </Card>
            </div>
        </div>
    );
}