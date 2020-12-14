import React from "react";
import {Button, Card, Form} from "react-bootstrap";
import {Link} from "react-router-dom";

export default function Pricing(props) {

    return (
        <div className="row ml-5 pricing">
            <div className="col-3 ml-5 bg-dark mt-5">
                <Card className="m-5 bg-dark text-light border border-light">
                    <Card.Body>
                        <Card.Title className="bronze">Bronze Membership</Card.Title>
                        <Card.Subtitle className="mb-2 text-white-50 font-weight-bold">10$/year</Card.Subtitle>
                        <Card.Text>
                            Get access to 10 free book previews per year. As a writer you can publish one book per year and
                            get a chance to buy a book with 30% discount.
                        </Card.Text>
                        <Link to="/">
                            <Button variant="primary" type="submit" className="w-50 mt-3">
                                Buy
                            </Button>
                        </Link>
                    </Card.Body>
                </Card>
            </div>
            <div className="col-3 offset-1 bg-dark mt-5">
                <Card className="m-5 bg-dark text-light border border-light">
                    <Card.Body>
                        <Card.Title className="silver">Silver Membership</Card.Title>
                        <Card.Subtitle className="mb-2 text-white-50 font-weight-bold">30$/year</Card.Subtitle>
                        <Card.Text>
                            Get access to 50 free book previews per year. As a writer you can publish 3 books per year and
                            get a chance to buy a book with 50% discount.
                        </Card.Text>
                        <Link to="/">
                            <Button variant="primary" type="submit" className="w-50 mt-3">
                                Buy
                            </Button>
                        </Link>
                    </Card.Body>
                </Card>
            </div>
            <div className="col-3 offset-1 bg-dark mt-5">
                <Card className="m-5 bg-dark text-light border border-light">
                    <Card.Body>
                        <Card.Title className="golden">Golden Membership</Card.Title>
                        <Card.Subtitle className="mb-2 text-white-50 font-weight-bold">50$/year</Card.Subtitle>
                        <Card.Text>
                            Get access to unlimited free book previews per year. As a writer you can publish unlimited number of books per year and
                            get a chance to buy a book with 75% discount.
                        </Card.Text>
                        <Link to="/">
                            <Button variant="primary" type="submit" className="w-50 mt-3">
                                Buy
                            </Button>
                        </Link>
                    </Card.Body>
                </Card>
            </div>
        </div>
    );
}