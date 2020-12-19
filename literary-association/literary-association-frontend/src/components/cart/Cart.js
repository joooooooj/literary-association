import React, {useState} from "react";
import {Card, Button} from "react-bootstrap";

export default function Cart(props) {

    return ( 
        <div>
        <div className="row ml-5 mr-5 mb-5 pricing" >
            <div className="card w-100">
                <div className="card-header">
                    <div className="row">
                        <label className="col-7 ml-1">Item</label>
                        <label className="col-3 mr-4">Quantity</label>
                        <label className="col ">Price</label>
                        <i variant="outline-dark" className="material-icons mr-1 float-right">close</i>
                    </div>
                </div>
                <div className="card-body books-preview col-14 row row-cols-4 text-center">
                <Card.Img variant="top" src={"../images/books/3.jpg"} />
                <Card.Title className="w-100">
                    <label>THE BOY FROM THE WOODS </label>
                    <label className="mt-5 font-weight-light">Autor : Harlan Coben</label>
                </Card.Title>
                <Card.Title> 
                    <Button variant="outline-dark" className="add-remove-button">
                        <i className="material-icons">remove</i>
                    </Button>
                        <input className="w-25 col-2" defaultValue="1"/>
                    <Button variant="outline-dark" className="add-remove-button">
                        <i className="material-icons">add</i>
                    </Button>
                </Card.Title>
                <Card.Title>10$</Card.Title>
                </div>
            </div>
        </div>
        <div className="row ml-5 mr-5 mb-5 pricing">
            <div className="card w-100">
                <div className="card-header">
                    <div className="row">
                        <label className="col-7 ml-1">Item</label>
                        <label className="col-3 mr-4">Quantity</label>
                        <label className="col ">Price</label>
                        <i variant="outline-dark" className="material-icons mr-1 float-right">close</i>
                    </div>
                </div>
                <div className="card-body books-preview col-14 row row-cols-4 text-center">
                <Card.Img variant="top" src={"../images/books/4.jpg"} />
                <Card.Title className="w-100">
                    <label>CONFESSIONS OF AN ENGLISH OPIUM EATER </label>
                    <label className="mt-5 font-weight-light">Autor : Thomas de Quincey</label>
                </Card.Title>
                <Card.Title> 
                    <Button variant="outline-dark" className="add-remove-button">
                        <i className="material-icons">remove</i>
                    </Button>
                        <input className="w-25 col-2" defaultValue="1"/>
                    <Button variant="outline-dark" className="add-remove-button">
                        <i className="material-icons">add</i>
                    </Button>
                </Card.Title>
                <Card.Title>10$</Card.Title>
                </div>
            </div>
        </div>
        <div className="float-right mr-5 mb-5 w-25 text-center pt-2 card" style={{background: "#FFF"}}> 
        <Card.Title>Total: 20$</Card.Title>
        </div>
        </div>
    );
}