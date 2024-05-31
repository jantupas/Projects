import React from "react"

import "../about/aboutstyles.css"
import "./admissionstyles.css"

function Policy () {
    return (
        <div>
        <div className="department-main">
            <h1 className="dept-title">Departments in MindHaven School</h1>
            <p className="dept-desc">
                MindHaven School has four departments.
            </p>
            <br />
            <div className="department-cont">
                <div>
                    <h1 className="dept-item-title">Preschool Department</h1>
                    <ul className="dept-list">
                    <li>PLC1</li>
                    <li>PLC2</li>
                    <li>Kindergarten Levels</li>
                    </ul>
                </div>
                <div>
                    <h1 className="dept-item-title">Primary Department</h1>
                    <ul className="dept-list">
                    <li>Grade 1</li>
                    <li>Grade 1</li>
                    <li>Grade 3</li>
                    </ul>
                </div>
                <div>
                    <h1 className="dept-item-title">Special Education</h1>
                    <ul className="dept-list">
                    <li>Headstart</li>
                    <li>Partial Inclusion</li>
                    <li>Full Incusion</li>
                    </ul>
                </div>
                <div>
                    <h1 className="dept-item-title">Gradeschool Department</h1>
                    <ul className="dept-list">
                    <li>Grade 4</li>
                    <li>Grade 5</li>
                    <li>Grade 6</li>
                    </ul>
                </div>
            </div>
            </div>
            <br />
            <br />
            <div className="adm-pol">
                <h1 className="dept-title">Admission Policies</h1>
                <p className="dept-desc">Requirements for Admission</p>
                <br />
                <h1 className="pol-title">Age Requirement</h1>
                <p className="pol-desc"><b>Preschoolers:</b> Must be between 2-4 years old of the academic year.</p>
                <p className="pol-desc"><b>Kindergarten:</b> Must be at least 5 years old by October 31 of the academic year.</p>
                <br />
                <h1 className="pol-title">Immunization Record</h1>
                <p className="pol-desc">All children must have up-to-date immunization records in accordance 
                with local health department regulations.</p>
                <br />
                <h1 className="pol-title">Entrance Assessment</h1>
                <p className="pol-desc"><b>All new enrollees:</b> A developmental assessment may be conducted 
                to evaluate the child's readiness and placement in school.</p>
                <br />
                <h1 className="pol-title">Parent/Guardian Involvement</h1>
                <p className="pol-desc">Parents/guardians are required to attend an orientation 
                session and participate in school activities as needed.</p>
                <br />
                <h1 className="pol-title">Enrollment Application</h1>
                <p className="pol-desc">A completed enrollment application, including all required 
                documents and fees, must be submitted before the admission deadline.</p>
                <br />
                <h1 className="pol-title">Special Needs</h1>
                <p className="pol-desc">Parents/guardians of children with special needs are required to provide 
                documentation of the child's diagnosis and any necessary accommodations.</p>
                <br />
            </div>
        </div>
    )
}
export default Policy