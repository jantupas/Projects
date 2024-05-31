import React from "react"
import { Link } from "react-router-dom"
import Form from "./Form"
import Map from "./Map"
import Other from "./Other"
import "./contactstyles.css"

function Contact () {
    return (
        <div className="whole-contact-container">
            <div className="contact-background">
                <div className="contact-title">
                    <h1>Get in Touch with Us</h1>
                    <p>Send us a message by filling up the form below.</p>
                </div>
                <Form />
                <div className="next-title">
                    <h1>Visit Our Location</h1>
                    <p>You can visit us by using the map to see our location.</p>
                </div>
                <Map />
                <div className="next-title">
                    <h1>Other Methods</h1>
                    <p>You may also reach us through our Facebook page, emails, or telephone.</p>
                </div>
                <Other />
            </div>
        </div>
    )
}
export default Contact