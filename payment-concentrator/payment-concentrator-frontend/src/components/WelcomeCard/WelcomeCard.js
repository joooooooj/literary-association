import React from "react";
import "./WelcomeCard.scss";

export default function WelcomeCard() {
  return (
    <div className="WelcomeCard">
      <h1 className="WelcomeTittle">Sign up right now!</h1>
      <p className="WelcomeText">
        {" "}
        We are a company that proved payment services to anyone who needs it. We
        provide different kind of payment services such as via Bank, Paypal and
        Bitcoin. If you think this is what you need, feel free to submit your
        request and we will contact you soon!
      </p>
    </div>
  );
}
