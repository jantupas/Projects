import React from "react"

import Vismis from "./Vismis"
import Background from "./Background"
import Faculty from "./Faculty"
import History from "./History"
import "./aboutstyles.css"

import abtimg1 from "../../images/about/abtimg1.jpg"
import abtimg2 from "../../images/about/abtimg2.jpg"


function About () {
    return (
        <div className="whole-about-container">
            <div className="about-background">
            <div className="ad-image">
                    <img src={abtimg1} alt="mindhaven-students" className="ad-img"/>
                    <img src={abtimg2} alt="mindhaven-students" className="ad-img"/>
                </div>
                <div className="about-title">
                    <h1>We are MindHaven School Inc</h1>
                    <p>Get to know our school.</p>
                </div>
                <Vismis id="vismis"/>
                <br />
                <br />
                <Background id="background"/>
                <br />
                <br />
                <Faculty id="faculty"/>
                <br />
                <br />
                <History id="history" />
                <br />
                <br />
            </div>
        </div>
    )
}
export default About