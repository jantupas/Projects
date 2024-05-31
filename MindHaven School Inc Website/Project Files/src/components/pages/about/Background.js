import React from "react"
import imgexp1 from "../../images/about/imgexp1.jpg"
import imgexp2 from "../../images/about/imgexp2.jpg"
import imgplay from "../../images/about/imgplay.jpg"
import imgplay2 from "../../images/about/imgplay2.jpg"
import imgprog from "../../images/about/imgprog.jpg"
import imgprog2 from "../../images/about/imgprog2.jpg"

import "./aboutstyles.css"

function Background() {
    return (
        <div className="background-container">
            <h1>School Background</h1>
            <p>
                MindHaven is a well-established educational institution with over 
                30 years of experience in the field. This extensive experience 
                demonstrates our long-term commitment to providing quality 
                education and our deep understanding of educational practices. 
                MindHaven has received recognition from SENIA, UNESCO, and IFIP.
            </p>
            <div className="exp-img-container">
                <img src={imgexp2} alt="experience photo" className="imgexp"/>
                <img src={imgexp1} alt="experience photo 2" className="imgexp"/>
            </div>
            <br />
            <br />
            <h1>Progressive, Play-based, and Brain-based School</h1>
            <p>
                MindHaven adopts a progressive, play-based, and brain-based approach to education. 
                This means that instead of relying solely on traditional teaching methods and 
                standardized curricula, we emphasize learning through play. 
                This approach recognizes that children learn best when they are engaged, curious, 
                and actively involved in their learning process. 
                By incorporating play into our educational philosophy, 
                we creates a more dynamic and interactive learning environment that can better cater 
                to each child's individual needs and interests.
            </p>
            <div className="exp-img-container">
                <img src={imgplay} alt="experience photo" className="imgexp"/>
                <img src={imgplay2} alt="experience photo 2" className="imgexp"/>
            </div>
            <br />
            <br />
            <h1>Whole Child, Whole School, Whole Community Inclusive Program</h1>
            <p>
            One of the standout features of MindHaven is our commitment to inclusive and personalized education. 
            Rather than offering a standardized, one-size-fits-all school program, we tailor our educational programs 
            to meet the unique needs and abilities of each child. This personalized approach ensures that each 
            student receives an education that is tailored to their individual strengths, interests, and 
            learning styles, allowing them to reach their full potential.
            </p>
            <div className="exp-img-container">
                <img src={imgprog} alt="experience photo" className="imgexp"/>
                <img src={imgprog2} alt="experience photo 2" className="imgexp"/>
            </div>
        </div>
    )
}
export default Background