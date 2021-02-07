import React, {useState, useEffect} from "react";
import {useForm} from "react-hook-form";

import "./WelcomeCard.scss";
import {Form, Alert} from "react-bootstrap";
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
    const [showAlert, setShowAlert] = useState(false);
    const [alertVariant, setAlertVariant] = useState('success');

    /* Validation */
    const {register, errors, handleSubmit} = useForm();

    useEffect(() => {
        PaymentMethodsService.getAll().then((data) => setPaymentMethods(data));
    }, []);

    const showFormClickHandler = () => {
        setVisible(true);
    };

    function methodsOnChangeHandler(event) {
        const selectedOptions = [...event.target.selectedOptions].map(o => o.value);
        console.log(selectedOptions);
        const methods = selectedOptions.map(option => {
            return paymentMethods.find(m => m.name === option);
        });
        console.log(methods);
        setRequest({...request, paymentMethods: methods});
    }

    const createRequestClickHandler = (formData) => {
        formData.paymentMethods = request.paymentMethods;
        SubscriptionRequestsService.createRequest(formData)?.then((data) => {
            console.log(data);
            setShowAlert(true);
            setAlertVariant('success');
            setTimeout(() => {
                setShowAlert(false);
            }, 5000);
        }).catch((error) => {
            setShowAlert(true);
            setAlertVariant('danger');
            setTimeout(() => {
                setShowAlert(false);
            }, 5000);
        });
    }

    return (
        <div className="Content">
            <Alert className="Alert" variant={alertVariant} show={showAlert} dismissible transition={true}>
                {alertVariant === "success" ? "You have submitted request successfully." : "Please fill in all the data."}
            </Alert>
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
                <Form onSubmit={handleSubmit(createRequestClickHandler)}>
                    <Form.Group
                        className="InputElement">
                        <Form.Label className="Label">Username</Form.Label>
                        <Form.Control type="text" placeholder="Enter username"
                                      name="username" ref={register({required: true})}
                                      isInvalid={!!errors.username}/>
                        {errors.organizationName &&
                        <Form.Control.Feedback type="invalid">
                            Username is required.
                        </Form.Control.Feedback>}
                    </Form.Group>
                    <Form.Group
                        className="InputElement">
                        <Form.Label className="Label">Password</Form.Label>
                        <Form.Control type="password" placeholder="Enter password"
                                      name="password"
                                      ref={register(
                                            {
                                              required: {
                                                  value: true,
                                                  message: "Password is required."
                                              },
                                              pattern: {
                                                  value: /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/,
                                                  message: "Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character!"
                                              }
                                          })}
                                      isInvalid={!!errors.password}/>
                        {errors.password &&
                        <Form.Control.Feedback type="invalid">
                            {errors.password.message}
                        </Form.Control.Feedback>}
                    </Form.Group>
                    <Form.Group
                        className="InputElement"
                        controlId="exampleForm.ControlInput1"
                    >
                        <Form.Label className="Label">Organization name</Form.Label>
                        <Form.Control type="text" placeholder="Enter organization name"
                                      name="organizationName" ref={register({required: true})}
                                      isInvalid={!!errors.organizationName}/>
                        {errors.organizationName &&
                        <Form.Control.Feedback type="invalid">
                            Organization name is required.
                        </Form.Control.Feedback>}
                    </Form.Group>
                    <Form.Group
                        className="InputElement"
                        controlId="exampleForm.ControlInput2"
                    >
                        <Form.Label className="Label">Organization email</Form.Label>
                        <Form.Control type="text" placeholder="Enter organization email"
                                      name="organizationEmail" ref={register({required: true})}
                                      isInvalid={!!errors.organizationEmail}/>
                        {errors.organizationEmail &&
                        <Form.Control.Feedback type="invalid">
                            Organization email is required.
                        </Form.Control.Feedback>}
                    </Form.Group>
                    <Form.Group
                        controlId="exampleForm.ControlSelect2"
                        className="InputElement"
                    >
                        <Form.Label className="Label">Select payment methods</Form.Label>
                        { paymentMethods &&
                        <Form.Control as="select" multiple onChange={e => methodsOnChangeHandler(e)}
                            name="organizationPaymentMethods" ref={register({required: true})}
                            isInvalid={!!errors.organizationPaymentMethods}>
                            { paymentMethods.map(method => {
                                return <option key={method.id} value={method.name}>{method.name}</option>
                            })}
                        </Form.Control>
                        }
                        {errors.organizationPaymentMethods &&
                        <Form.Control.Feedback type="invalid">
                            Organization payment methods are required.
                        </Form.Control.Feedback>}
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
                            name="organizationDescription" ref={register({required: true})}
                            isInvalid={!!errors.organizationDescription}
                        />
                        {errors.organizationDescription &&
                        <Form.Control.Feedback type="invalid">
                            Organization description is required.
                        </Form.Control.Feedback>}
                    </Form.Group>
                    <div className="ButtonWrapper ">
                        <button className="Button Gray" type="submit"
                        >Subscribe
                        </button>
                    </div>
                </Form>{" "}

            </div>
        </div>
    );
}
