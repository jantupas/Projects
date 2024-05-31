import React from "react"
import imgfac from "../../images/about/imgfac.jpg"
import imgfac2 from "../../images/about/imgfac2.jpg"
import "./aboutstyles.css"

function Faculty () {
    return (
        <div className="background-container">
            <h1>Our Educarers</h1>
            <p>
                The MindHaven faculty and staff are not just teachers, they are <b>EDUCARERS</b>. They educate and care because we believe:
            </p>
            <ol className="faculty-list">
                <li>That in order for children to learn, they have to be well cared for, 
                    and in order for them to be nurtured, they must also be taught.</li>
                <li>That  teachers should never consider themselves “substitute” for the parents but rather as “supplements” 
                    in helping and supporting the family, serving, in effect, as a new extended family.</li>
            </ol>
            <p>MindHaven teachers are professionals chosen for both their academic accomplishments and their attitudes toward children. 
                They participate in on-going certified training and staff development seminars. 
                In accordance with our commitment for personal and professional growth of our teachers,
                 Staff Development Day is held  every Friday of every week.</p>
            <div className="exp-img-container">
                <img src={imgfac} alt="faculty photo" className="imgexp"/>
                <img src={imgfac2} alt="faculty photo 2" className="imgexp"/>
            </div>
        </div>
    )
}
export default Faculty