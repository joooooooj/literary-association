import React, {useState} from "react";
import "./Login.scss";
import LoginIcon from "@material-ui/icons/AccountCircleSharp";
import PassIcon from "@material-ui/icons/LockSharp";
import {Redirect} from "react-router";

export default function LoginComponent(props) {
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();
    const [redirect, setRedirect] = useState(false);

    const usernameOnChangeHandler = (value) => {
        setUsername(value);
    }

    const passwordOnChangeHandler = (value) => {
        setPassword(value);
    }

    const a = (value) => {
        props.log(value);
    }

    const login = () => {
        fetch("http://localhost:8081/api/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({username, password}),
        })
            .then(response => response.json())
            .then(data => {
                // localStorage.setItem("token", data.accessToken);
                // localStorage.setItem("roles", data.roles);
                a(data.accessToken);
                setRedirect(true);
            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }

    // const logout = () => {
    //     a(false);
    //     setRedirect(false);
    // }

    if (redirect) {
        return <Redirect to="/dashboard"/>
    }

    return (

        <div className="Login">
            <div className="input-container">
                <input type="text" placeholder="Username" onChange={e => usernameOnChangeHandler(e.target.value)}/>
                <i>
                    <LoginIcon/>
                </i>
            </div>
            <div className="input-container">
                <input type="password" placeholder="Password" onChange={e => passwordOnChangeHandler(e.target.value)}/>
                <i>
                    <PassIcon/>
                </i>
            </div>
            <button type="submit" className="ButtonLogin" onClick={() => login()}>
                Log In
            </button>
        </div>
    );
}
