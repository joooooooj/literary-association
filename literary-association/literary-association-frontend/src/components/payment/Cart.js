import React from "react";
import {Button, ButtonGroup, Table} from "react-bootstrap";

export default function Cart() {

    const handleCheckout = () => {
        //
        fetch('http://localhost:8081/payment-method/subscriber/vulkan', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization' : 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsdSIsInN1YiI6InZ1bGthbiIsImF1ZCI6IndlYiIsImlhdCI6MTYxMDI5NTc3MCwiZXhwIjoxNjEwMzgyMTcwLCJVU0VSX1JPTEVTIjpbeyJpZCI6MiwibmFtZSI6IlJPTEVfU1VCU0NSSUJFUiIsInBlcm1pc3Npb25zIjpbeyJpZCI6NiwibmFtZSI6IklOSVRJQVRFX1BBWU1FTlQiLCJhdXRob3JpdHkiOiJJTklUSUFURV9QQVlNRU5UIn1dfV19.kczTiRPP7t8w2wr4w8lmQuDNyjMhvvTSD2AuuOT0QfL9BSzVGsxgZ_iGafJ9tp8wWxAQpMmBdjYLoIL89AbsCw'
            },
            body:
                JSON.stringify({
                    merchantOrderId: "123",
                    merchantTimestamp: "2019-04-28T14:45:15",
                    amount: "30"
                })
        })
            .then(result => result.json())
            .then(data => {
                window.location.replace(data.url);
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
                        <td className="text-center"><img style={{maxHeight:"100px", height:"100px"}} src={"../images/books/5.jpg"}/></td>
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
                        <td className="text-center"><img style={{maxHeight:"100px", height:"100px"}} src={"../images/books/1.jpg"}/></td>
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
                        <td className="text-center"><img style={{maxHeight:"100px", height:"100px"}} src={"../images/books/2.jpg"}/></td>
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