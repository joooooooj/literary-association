import "./App.css";
import Navbar from "./components/UI/Navbar/Navbar";
import Routes from "./Routes"
import {useState} from "react";

export default function App() {
    const [loggedIn, setLoggedIn] = useState(false);

    const log = (value) => {
        setLoggedIn(value);
    }

    return (
        <div>
            <Navbar loggedIn={loggedIn} log={log}/>
            <Routes loggedIn={loggedIn} log={log}/>
        </div>
    );
}
