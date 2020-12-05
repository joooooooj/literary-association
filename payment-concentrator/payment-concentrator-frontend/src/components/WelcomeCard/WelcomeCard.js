import React, { useState } from "react";
import "./WelcomeCard.scss";
import { Form, Button } from "react-bootstrap";

export default function WelcomeCard() {
  const [visible, setVisible] = useState(false);

  const showFormClickHandler = () => {
    setVisible(true);
  };

  return (
    <div className="Content">
      <div className="WelcomeCard">
        <h1 className="WelcomeTittle">Sign up right now!</h1>
        <p className="WelcomeText">
          {" "}
          We are a company that proved payment services to anyone who needs it.
          We provide different kind of payment services such as via Bank, Paypal
          and Bitcoin. If you think this is what you need, feel free to submit
          your request and we will contact you soon!
        </p>
        <button
          variant="success"
          className="Button Green"
          onClick={showFormClickHandler}
        >
          Sign up!
        </button>
      </div>
      <div className="Subscribe" hidden={!visible}>
        <Form>
          <Form.Group
            className="InputElement"
            controlId="exampleForm.ControlInput1"
          >
            <Form.Label className="Label">Organization name</Form.Label>
            <Form.Control type="text" placeholder="Enter organiztion name" />
          </Form.Group>
          <Form.Group
            controlId="exampleForm.ControlSelect2"
            className="InputElement"
          >
            <Form.Label className="Label">Select payment methods</Form.Label>
            <Form.Control as="select" multiple>
              <option>Bank</option>
              <option>PayPal</option>
              <option>Bitcoin</option>
            </Form.Control>
          </Form.Group>
          <Form.Group
            controlId="exampleForm.ControlTextarea1"
            className="InputElement"
          >
            <Form.Label className="Label">
              Description of your business
            </Form.Label>
            <Form.Control
              as="textarea"
              rows={3}
              placeholder="Describe what you do"
              style={{ resize: "none" }}
            />
          </Form.Group>
        </Form>{" "}
        <div className="ButtonWrapper ">
          <button className="Button Gray">Subscribe</button>
        </div>
      </div>
    </div>
  );
}
