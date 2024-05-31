import React from "react"
import { Link } from "react-router-dom"
import "./contactstyles.css"

function Map () {
    return (
        <div className="map-content">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3908.341663751015!2d122.73996087489537!3d11.598964288604275!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x33a5f29645c53c97%3A0x8aac7a3815a71656!2sMINDHAVEN%20SCHOOL%20INC.!5e0!3m2!1sen!2sph!4v1712846220359!5m2!1sen!2sph" 
                width="1000" height="450" 
                style={{ border: "0" }} /* Fix: Use inline style object */
                allowfullscreen="" 
                loading="lazy" 
                referrerpolicy="no-referrer-when-downgrade"
                className="map-loc">
            </iframe>
        </div>
    )
}
export default Map