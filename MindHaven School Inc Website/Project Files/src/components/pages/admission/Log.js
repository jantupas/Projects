import React from "react"
import { Link } from "react-router-dom"
import "./admissionstyles.css"

function Log () {
    return (
        <div className="log-container">
            <div className="log-content">
                <div className="desc-log">
                    <h2>Track your Application</h2>
                    <Link to="/user" className="log-link">Click Here to Login as User</Link>
                </div>
                <div className="desc-log">
                    <h2>Review Application</h2>
                    <Link to="/admin" className="log-link">Click Here to Login as Admin</Link>
                </div>
            </div>
        </div>
    )
}
export default Log