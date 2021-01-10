import React, {useState} from "react";
import {Button, ButtonGroup, Table} from "react-bootstrap";

export default function Cart() {

    // const [purchaseData, setPurchaseData] = useState();

    const handleCheckout = () => {
        fetch('http://localhost:8080/api/auth/purchase-book', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body:
                JSON.stringify({
                    price: 30,
                    bookList: [
                        {
                            id: 1
                        },
                        {
                            id: 2
                        },
                        {
                            id: 3
                        }
                    ]
                })
        })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                // setPurchaseData(data);
                fetch('http://localhost:8081/payment-method/subscriber/vulkan', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': 'Bearer ' + data.token
                    },
                    body:
                        JSON.stringify({
                            merchantOrderId: data.orderId,
                            merchantTimestamp: data.timestamp,
                            amount: data.amount
                        })
                })
                    .then(result => result.json())
                    .then(data => {
                        window.location.replace(data.url);
                    })
                    .catch((error) => {
                        console.log('Error:' + error);
                    });
            })
            .catch((error) => {
                console.log('Error:' + error);
            });

    }

    return (
        <div className="bg-dark p-5 cart">
            <div className="bg-dark p-5 border border-light">
                <h2 className="text-left text-light mb-4">
                    Cart
                </h2>
                <Table striped bordered hover variant="dark" className="cart-table">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th></th>
                        <th>Author</th>
                        <th>Title</th>
                        <th>Price</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td className="text-center"><img style={{maxHeight: "100px", height: "100px"}}
                                                         src={"../images/books/5.jpg"}/></td>
                        <td>Stephen King</td>
                        <td>RITA HAYWORTH AND SHAWSHANK REDEMPTION</td>
                        <td>10$</td>
                        <td className="text-center">
                            <Button variant="outline-danger">
                                REMOVE
                            </Button>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td className="text-center"><img style={{maxHeight: "100px", height: "100px"}}
                                                         src={"../images/books/1.jpg"}/></td>
                        <td>Bernard Cornwell</td>
                        <td>THE LAST KINDGDOM</td>
                        <td>10$</td>
                        <td className="text-center">
                            <Button variant="outline-danger">
                                REMOVE
                            </Button>
                        </td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td className="text-center"><img style={{maxHeight: "100px", height: "100px"}}
                                                         src={"../images/books/2.jpg"}/></td>
                        <td>Elizabeth Gilbert</td>
                        <td>CITY OF GIRLS</td>
                        <td>10$</td>
                        <td className="text-center">
                            <Button variant="outline-danger">
                                REMOVE
                            </Button>
                        </td>
                    </tr>
                    </tbody>
                </Table>
                <div className="mb-5 mt-4">
                    <h2 className="float-left text-light">Total price : 30$</h2>
                    <Button variant="outline-success" className="float-right checkout" onClick={() => {
                        handleCheckout();
                    }}>
                        CHECKOUT
                    </Button>
                </div>
            </div>
        </div>
    );
}