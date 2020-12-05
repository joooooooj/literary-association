import React from "react";
import {Carousel} from "react-bootstrap";
import Login from "./Login.js"
import bg1 from "../../styles/images/bg-1.jpg"
import bg2 from "../../styles/images/bg-2.jpg"
import bg4 from "../../styles/images/bg-4.jpg"

export default function Home() {
    return (
        <div className="row ml-4 mr-5">
            <Carousel className="adjust-carousel col-6 h-100">
                <Carousel.Item interval={4000}>
                    <img
                        className="d-block w-100"
                        src={bg1}
                        alt="First slide"
                    />
                    <Carousel.Caption>
                        <h3>Neil Gaiman</h3>
                        <p>A book is a dream that you hold in your hand.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item interval={4000}>
                    <img
                        className="d-block w-100"
                        src={bg2}
                        alt="Third slide"
                    />
                    <Carousel.Caption>
                        <h3>Stephen King</h3>
                        <p>Books are a uniquely portable magic.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item interval={4000}>
                    <img
                        className="d-block w-100"
                        src={bg4}
                        alt="Third slide"
                    />
                    <Carousel.Caption>
                        <h3>George R.R. Martin</h3>
                        <p>A reader lives a thousand lives before he dies.</p>
                    </Carousel.Caption>
                </Carousel.Item>
            </Carousel>
            <div className="col-5 offset-1 content bg-dark h-75">
                <Login/>
            </div>
        </div>
    );
}