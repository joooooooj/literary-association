import React, {useState, useEffect} from "react";

export default function ExampleComponent() {

    const [test, updateTest] = useState("");

    useEffect(() => {
        updateTest("Hello");
    }, []);

    const exampleFunction1 = () => {
    }

    function exampleFunction2() {
    }

    return (
        <div className="">
            <div className="">
                <div className="">
                    <h1>Uuups</h1>
                    <p>Stranica koju ste tražili ne postoji.</p>
                    <button onClick={() => exampleFunction1}></button>
                </div>
            </div>
        </div>
    );
}