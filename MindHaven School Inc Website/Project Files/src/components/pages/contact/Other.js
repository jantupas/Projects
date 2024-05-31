import React from "react"
import { Link } from "react-router-dom"
import "./contactstyles.css"
import fblogo from "./fblogo.png"
import telephonelogo from "./phonelogo.png"
import cellphonelogo from "./cellphonelogo.png"

function Other () {
    return (
        <div>
            <div className="other-content">
                <a href="https://www.facebook.com/mindhavenschoolroxas" target="_blank" rel="noopener noreferrer">
                    <img src={fblogo} className="fblogo" alt="fblogo"/>
                </a>
            </div>
            <div className="email-collection">
                <div className="email-item">
                    <h2>School</h2>
                    <p>mindhavenschool@gmail.com</p>
                </div>
                <div className="email-item">
                    <h2>Principal</h2>
                    <p>abc@gmail.com</p>
                </div>
                <div className="email-item">
                    <h2>Faculty</h2>
                    <p>efg@gmail.com</p>
                </div>
                <div className="email-item">
                    <h2>School</h2>
                    <p>mindhavenschool@gmail.com</p>
                </div>
                <div className="email-item">
                    <h2>Principal</h2>
                    <p>abc@gmail.com</p>
                </div>
                <div className="email-item">
                    <h2>Faculty</h2>
                    <p>efg@gmail.com</p>
                </div>
            </div>
            <div className="telno">
                <div className="tel-item">
                    <img src={telephonelogo} className="phonelogo" alt="telephonelogo" />
                    <h2>(036) 621 1383</h2>
                </div>
                <div className="tel-item">
                    <img src={telephonelogo} className="phonelogo" alt="telephonelogo" />
                    <h2>(036) 621 1475</h2>
                </div>
                <div className="tel-item">
                    <img src={telephonelogo} className="phonelogo" alt="telephonelogo" />
                    <h2>(036) 520 1099</h2>
                </div>
                <div className="tel-item">
                    <img src={cellphonelogo} className="cellphonelogo" alt="cellphonelogo" />
                    <h2>(+63) 968 726 0752</h2>
                </div>
            </div>
        </div>
    )
}
export default Other