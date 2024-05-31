import React from "react"
import { Link } from "react-router-dom"
import Announcedash from "./Announcedash"
import Admdashnav from "./Admdashnav"


import "./dashboardstyles.css"


function Admdash () {
    return (
        <div>
            <div>
                <h1>What would you like to do?</h1>
                <Admdashnav />
            </div>
        </div>
      )
    }

export default Admdash