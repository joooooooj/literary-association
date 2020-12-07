import React, {useEffect, useState} from "react";
import {ButtonGroup, ToggleButton} from "react-bootstrap";
import SubscriptionRequestsService from "../../services/SubscriptionRequestsService";
import SubscriptionRequests from "../SubsciptionRequests/SubscriptionRequests";

export default function AdminDashboard() {
    const [radioValue, setRadioValue] = useState("1");
    const [requests, setRequests] = useState([]);

    useEffect(() => {
        SubscriptionRequestsService.getAll().then((data) => setRequests(data));
    }, [])

    const approveOnClickHandler = (requestId) => {
        SubscriptionRequestsService.approve(requestId).then(() => {
            SubscriptionRequestsService.getAll().then((data) => setRequests(data));
        });
    }

    const declineOnClickHandler = (requestId) => {
        SubscriptionRequestsService.decline(requestId).then(() => {
            SubscriptionRequestsService.getAll().then((data) => setRequests(data));
        });
    }

    return (
        <React.Fragment>
            <div className="row row-cols-2 justify-content-center mt-5 pl-5 pr-5 w-100">
                <ButtonGroup toggle>
                    <ToggleButton
                        className="mr-sm-1"
                        type="radio"
                        variant={radioValue === "1" ? "primary" : "secondary"}
                        name="radio"
                        value="1"
                        checked={radioValue === "1"}
                        onChange={(e) => setRadioValue(e.currentTarget.value)}
                    >
                        Subscription Requests
                    </ToggleButton>
                    <ToggleButton
                        type="radio"
                        variant={radioValue === "2" ? "primary" : "secondary"}
                        name="radio" value="2"
                        checked={radioValue === "2"}
                        onChange={(e) => setRadioValue(e.currentTarget.value)}
                    >
                        Payment methods
                    </ToggleButton>
                </ButtonGroup>
            </div>
            <SubscriptionRequests requests={requests} approve={approveOnClickHandler}
                                  decline={declineOnClickHandler}/>
        </React.Fragment>);
}