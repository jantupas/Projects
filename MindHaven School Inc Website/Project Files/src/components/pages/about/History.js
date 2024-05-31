import React from "react"
import timeimg from "../../images/about/timelineimg.png"
import "./aboutstyles.css"

function History () {
    return (
        <div className="time-background-container">
            <h1>History of the School</h1>
            <img className="timelineimg" src={timeimg} alt="timeline" />
        </div>
    )
}
export default History