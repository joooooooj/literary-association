import {Button, Form} from "react-bootstrap";
import './App.css';
import {useState} from 'react';

function  App() {

  const [pan, setPan] = useState("");
  const [securityCode, setSecurityCode] = useState("");
  const [cardholderName, setCardholderName] = useState("");
  const [expireMonth, setExpireMonth] = useState("");
  const [expireYear, setExpireYear] = useState("");
  const [error, setError] = useState(false);

  const handleSubmit = () => {
    let formData = {
      pan: pan,
      securityCode: securityCode,
      cardholderName: cardholderName,
      expireDate: expireMonth + "-" + expireYear
    }
    const url = 'http://localhost:8084/transaction/1';
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    };
    fetch(url, options)
    .then(response => {
        if(!response.ok){
            alert("There's been an error.");
        }
       console.log("response");
    });
  }

  const panOnChangeHandler = (value) => {  
    setPan(value);  
  }

  const securityCodeOnChangeHandler = (value) => {
    setSecurityCode(value);
  }

  const cardholderOnChangeHandler = (value) => {
    setCardholderName(value);
  }

  const expireMonthOnChangeHandler = (value) => {
    setExpireMonth(value);
  }

  const expireYearOnChangeHandler = (value) => {
    setExpireYear(value);
  }

  return (
    <div >
      <div className="App-header">
      <h1>Bank A</h1>
      <h4>Enter your card information here</h4>
        <Form>
          <Form.Group className="text-left">
            <Form.Label>PAN:</Form.Label>
            <Form.Control className="form-input float-right" autoComplete="off" maxLength="19" 
            type="text" placeholder="Enter PAN" onChange={(e) => panOnChangeHandler(e.target.value)} />
          </Form.Group>
          <Form.Group className="text-left">
            <Form.Label>Security code:</Form.Label>
            <Form.Control className="form-input float-right" type="text" 
            placeholder="Enter security code" onChange={(e) => securityCodeOnChangeHandler(e.target.value)} />
          </Form.Group>
          <Form.Group className="text-left">
            <Form.Label>Cardholder name:</Form.Label>
            <Form.Control className="form-input float-right" type="text" 
            placeholder="Enter cardholder name" onChange={(e) => cardholderOnChangeHandler(e.target.value)} />
          </Form.Group>
          <Form.Group className="text-left">
            <Form.Label>Expire date:</Form.Label>
            <div className="row float-right">
            <select className="form-select" onChange={(e) => expireMonthOnChangeHandler(e.target.value)}>
              <option value="">--</option>
              <option value="01">01</option>
              <option value="02">02</option>
              <option value="03">03</option>
              <option value="04">04</option>
              <option value="05">05</option>
              <option value="06">06</option>
              <option value="07">07</option>
              <option value="08">08</option>
              <option value="09">09</option>
              <option value="10">10</option>
              <option value="11">11</option>
              <option value="12">12</option>
            </select>
            <select className="form-select" onChange={(e) => expireYearOnChangeHandler(e.target.value)}>
              <option value="">----</option>
              <option value="20">2020</option>
              <option value="21">2021</option>
              <option value="22">2022</option>
              <option value="23">2023</option>
              <option value="24">2024</option>
              <option value="25">2025</option>
              <option value="26">2026</option>
              <option value="27">2027</option>
              <option value="28">2028</option>
              <option value="29">2029</option>
              <option value="30">2030</option>
              <option value="31">2031</option>
              <option value="32">2032</option>
              <option value="33">2033</option>
              <option value="34">2034</option>
              <option value="35">2035</option>
              <option value="36">2036</option>
              <option value="37">2037</option>
              <option value="38">2038</option>
              <option value="39">2039</option>
            </select>
            </div>
          </Form.Group>
          <Button variant="success" type="submit" onClick={() => handleSubmit()} className="btn btn-primary form-input button">Pay</Button> 
          <Button className="form-input button">Cancel</Button>
        </Form>
      </div>
    </div>
  );
  
}

export default App;
