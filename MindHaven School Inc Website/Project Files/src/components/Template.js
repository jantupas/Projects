import React from "react"
import { Outlet } from "react-router-dom";

function template() {
    return (
        <div>
            <Outlet />
        </div>
    )
}

export default template