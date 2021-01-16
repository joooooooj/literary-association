import React from "react";

export default function Error() {
    return(
        <div className="bg-dark p-5 cart">
            <div className="bg-dark p-5 border border-light">
                <h2 className="text-left text-warning mb-4">
                    Order Error
                </h2>
                <h4 className="bg-dark text-light text-left">There was an error. Please try again.</h4>
            </div>
        </div>
    );
}