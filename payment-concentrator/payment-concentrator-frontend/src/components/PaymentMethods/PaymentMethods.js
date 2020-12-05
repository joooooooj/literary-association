import React from "react";
import { Carousel } from "react-bootstrap";
import BankIcon from "../../images/bank2.png";
import PayPalIcon from "../../images/paypal.png";
import BitcoinIcon from "../../images/bitcoin.png";

export default function paymentMehtodsComponent() {
  return (
    <Carousel>
      <Carousel.Item interval={5000}>
        <img
          src={BankIcon}
          width="500px"
          height="400px"
          alt="First slide"
          style={{
            marginTop: "10%",
            marginBottom: "10%",
            marginLeft: "37%",
          }}
        />

        <Carousel.Caption>
          <h3>Bank</h3>
          <p>
            We offer service of paying for items via bank. All you need to have
            is an account in a bank.
          </p>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item interval={5000}>
        <img
          src={PayPalIcon}
          width="500px"
          height="400px"
          alt="First slide"
          style={{ marginTop: "10%", marginBottom: "10%", marginLeft: "37%" }}
        />

        <Carousel.Caption>
          <h3>PayPal</h3>
          <p>
            We offer service of paying for items via paypal. All you need to
            have is a paypal account.
          </p>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item interval={5000}>
        <img
          src={BitcoinIcon}
          width="500px"
          height="400px"
          alt="First slide"
          style={{ marginTop: "10%", marginBottom: "10%", marginLeft: "37%" }}
        />

        <Carousel.Caption>
          <h3>Bank</h3>
          <p>
            We offer service of paying for items via bitcoin. All you need to
            have is a bitcoin wallet.
          </p>
        </Carousel.Caption>
      </Carousel.Item>
    </Carousel>
  );
}
