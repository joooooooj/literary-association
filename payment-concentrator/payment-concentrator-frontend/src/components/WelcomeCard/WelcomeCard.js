import React, {useState, useEffect} from "react";
import "./WelcomeCard.scss";
import {Form} from "react-bootstrap";
import PaymentMethodsService from "../../services/PaymentMethodsService";
import SubscriptionRequestsService from "../../services/SubscriptionRequestsService";

export default function WelcomeCard() {
    const [visible, setVisible] = useState(false);
    const [paymentMethods, setPaymentMethods] = useState([]);
    const [request, setRequest] = useState({
        organizationName: "",
        organizationEmail: "",
        organizationDescription: "",
        paymentMethods: [],
    })

    useEffect(() => {
        PaymentMethodsService.getAll().then((data) => setPaymentMethods(data));
    }, []);

    const showFormClickHandler = () => {
        setVisible(true);
    };

    const organizationNameOnChangeHandler = (value) => {
        setRequest({...request, organizationName: value})
    }

    const organizationEmailOnChangeHandler = (value) => {
        setRequest({...request, organizationEmail: value})
    }

    const organizationDescriptionOnChangeHandler = (value) => {
        setRequest({...request, organizationDescription: value})
    }

    function methodsOnChangeHandler(event) {
        const selectedOptions = [...event.target.selectedOptions].map(o => o.value);
        console.log(selectedOptions);
        const methods = selectedOptions.map(option => {
            return paymentMethods.find(m => m.name === option);
        });
        console.log(methods);
        setRequest({...request, paymentMethods: methods});
    }

    const createRequestClickHandler = () => {
        SubscriptionRequestsService.createRequest(request).then((data) => console.log(data));
    }

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
                        <Form.Control type="text" placeholder="Enter organization name"
                                      onChange={e => organizationNameOnChangeHandler(e.target.value)}/>
                    </Form.Group>
                    <Form.Group
                        className="InputElement"
                        controlId="exampleForm.ControlInput2"
                    >
                        <Form.Label className="Label">Organization email</Form.Label>
                        <Form.Control type="text" placeholder="Enter organization email"
                                      onChange={e => organizationEmailOnChangeHandler(e.target.value)}/>
                    </Form.Group>
                    <Form.Group
                        controlId="exampleForm.ControlSelect2"
                        className="InputElement"
                    >
                        <Form.Label className="Label">Select payment methods</Form.Label>
                        <Form.Control as="select" multiple onChange={e => methodsOnChangeHandler(e)}>
                            {paymentMethods.map(method => {
                                return <option key={method.id} value={method.name}>{method.name}</option>
                            })}
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
                            style={{resize: "none"}}
                            onChange={e => organizationDescriptionOnChangeHandler(e.target.value)}
                        />
                    </Form.Group>
                </Form>{" "}
                <div className="ButtonWrapper ">
                    <button className="Button Gray" onClick={() => createRequestClickHandler()}>Subscribe</button>
                </div>
            </div>
        </div>
    );
}
