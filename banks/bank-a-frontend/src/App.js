import {Button, Form} from "react-bootstrap";
import './App.css';

function App() {
  return (
    <div >
      <div className="App-header">
      <h1>Bank A</h1>
      <h4>Enter your card information here</h4>
        <Form>
          <Form.Group className="text-left">
            <Form.Label>PAN:</Form.Label>
            <Form.Control className="form-input float-right" autoComplete="off" maxLength="19" type="text" placeholder="Enter PAN"/>
          </Form.Group>
          <Form.Group className="text-left">
            <Form.Label>Security code:</Form.Label>
            <Form.Control className="form-input float-right" type="text" placeholder="Enter security code"/>
          </Form.Group>
          <Form.Group className="text-left">
            <Form.Label>Card holder name:</Form.Label>
            <Form.Control className="form-input float-right" type="text" placeholder="Enter card holder name"/>
          </Form.Group>
          <Form.Group className="text-left">
            <Form.Label>Expire date:</Form.Label>
            <div className="row float-right">
            <select className="form-select">
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
            <select className="form-select">
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
          <Button variant="success" type="submit" className="btn btn-primary form-input button">Pay</Button> 
          <Button className="form-input button">Cancel</Button>
        </Form>
      </div>
    </div>
  );
}

export default App;
