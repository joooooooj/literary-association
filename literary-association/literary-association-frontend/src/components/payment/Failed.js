import React from "react";

export default function Failed() {
    return(
        <div className="bg-dark p-5 cart">
            <div className="bg-dark p-5 border border-light">
                <h2 className="text-left text-danger mb-4">
                    Order Failed
                </h2>
                <h4 className="bg-dark text-light text-left">Your order request failed. Please try again.</h4>
            </div>
        </div>
    );
}