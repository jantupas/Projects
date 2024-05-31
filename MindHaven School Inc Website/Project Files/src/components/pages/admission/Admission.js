import React from "react"
import { Link } from "react-router-dom"

import "./admissionstyles.css"

import admimg1 from "../../images/admission/admimg1.jpg"
import admimg2 from "../../images/admission/admimg2.jpg"


import Personal from "./Personal"
import Log from "./Log"
import Policy from "./Policy"

function Admission () {
    return (
        <div className="whole-admission-container">
            <div className="admission-background">
                <div className="ad-image">
                    <img src={admimg2} alt="mindhaven-students" className="ad-img"/>
                    <img src={admimg1} alt="mindhaven-students" className="ad-img"/>
                </div>
                <div className="adm-title">
                    <h1>Join us at MindHaven School Inc</h1>
                    <p>A Place to Learn, Laugh, and Love</p>
                </div>
                <br />
                <Policy />
                <div className="adm-form">
                    <Personal />
                    <Log />
                </div>
            </div>
        </div>
    )
}

export default Admission