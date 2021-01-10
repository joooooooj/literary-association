import React from "react";

export default function Success() {
    return(
        <div className="bg-dark p-5 cart">
            <div className="bg-dark p-5 border border-light">
                <h2 className="text-left text-success mb-4">
                    Order Success
                </h2>
                <h4 className="bg-dark text-light text-left">Thank you! Your order has been successfully completed.</h4>
            </div>
        </div>
    );
}