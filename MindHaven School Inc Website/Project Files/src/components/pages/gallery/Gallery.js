import React from "react";
import Gallerycont from "./Gallerycont";

import home1 from "../../images/gallery/home/home1.jpg"
import home2 from "../../images/gallery/home/home2.jpg"
import home3 from "../../images/gallery/home/home3.jpg"
import home4 from "../../images/gallery/home/home4.jpg"
import home5 from "../../images/gallery/home/home5.jpg"
import home6 from "../../images/gallery/home/home6.jpg"
import home7 from "../../images/gallery/home/home7.jpg"
import home8 from "../../images/gallery/home/home8.jpg"
import home9 from "../../images/gallery/home/home9.jpg"
import home10 from "../../images/gallery/home/home10.jpg"
import home11 from "../../images/gallery/home/home11.jpg"
import home12 from "../../images/gallery/home/home12.jpg"

import earthimg1 from "../../images/gallery/earth-day/earthimg1.jpg"
import earthimg2 from "../../images/gallery/earth-day/earthimg2.jpg"
import earthimg3 from "../../images/gallery/earth-day/earthimg3.jpg"
import earthimg4 from "../../images/gallery/earth-day/earthimg4.jpg"
import earthimg5 from "../../images/gallery/earth-day/earthimg5.jpg"
import earthimg6 from "../../images/gallery/earth-day/earthimg6.jpg"
import earthimg7 from "../../images/gallery/earth-day/earthimg7.jpg"
import earthimg8 from "../../images/gallery/earth-day/earthimg8.jpg"
import earthimg9 from "../../images/gallery/earth-day/earthimg9.jpg"
import earthimg10 from "../../images/gallery/earth-day/earthimg10.jpg"
import earthimg11 from "../../images/gallery/earth-day/earthimg11.jpg"
import earthimg12 from "../../images/gallery/earth-day/earthimg12.jpg"

import beachimg1 from "../../images/gallery/beach-clean-up/beachimg1.jpg"
import beachimg2 from "../../images/gallery/beach-clean-up/beachimg2.jpg"
import beachimg3 from "../../images/gallery/beach-clean-up/beachimg3.jpg"
import beachimg4 from "../../images/gallery/beach-clean-up/beachimg4.jpg"
import beachimg5 from "../../images/gallery/beach-clean-up/beachimg5.jpg"
import beachimg6 from "../../images/gallery/beach-clean-up/beachimg6.jpg"
import beachimg7 from "../../images/gallery/beach-clean-up/beachimg7.jpg"
import beachimg8 from "../../images/gallery/beach-clean-up/beachimg8.jpg"
import beachimg9 from "../../images/gallery/beach-clean-up/beachimg9.jpg"
import beachimg10 from "../../images/gallery/beach-clean-up/beachimg10.jpg"
import beachimg11 from "../../images/gallery/beach-clean-up/beachimg11.jpg"
import beachimg12 from "../../images/gallery/beach-clean-up/beachimg12.jpg"

import waterimg1 from "../../images/gallery/water-safety-exercises/waterimg1.jpg"
import waterimg2 from "../../images/gallery/water-safety-exercises/waterimg2.jpg"
import waterimg3 from "../../images/gallery/water-safety-exercises/waterimg3.jpg"
import waterimg4 from "../../images/gallery/water-safety-exercises/waterimg4.jpg"
import waterimg5 from "../../images/gallery/water-safety-exercises/waterimg5.jpg"
import waterimg6 from "../../images/gallery/water-safety-exercises/waterimg6.jpg"
import waterimg7 from "../../images/gallery/water-safety-exercises/waterimg7.jpg"
import waterimg8 from "../../images/gallery/water-safety-exercises/waterimg8.jpg"
import waterimg9 from "../../images/gallery/water-safety-exercises/waterimg9.jpg"
import waterimg10 from "../../images/gallery/water-safety-exercises/waterimg10.jpg"
import waterimg11 from "../../images/gallery/water-safety-exercises/waterimg11.jpg"
import waterimg12 from "../../images/gallery/water-safety-exercises/waterimg12.jpg"

import campimg1 from "../../images/gallery/camping/campimg1.jpg"
import campimg2 from "../../images/gallery/camping/campimg2.jpg"
import campimg3 from "../../images/gallery/camping/campimg3.jpg"
import campimg4 from "../../images/gallery/camping/campimg4.jpg"
import campimg5 from "../../images/gallery/camping/campimg5.jpg"
import campimg6 from "../../images/gallery/camping/campimg6.jpg"
import campimg7 from "../../images/gallery/camping/campimg7.jpg"
import campimg8 from "../../images/gallery/camping/campimg8.jpg"
import campimg9 from "../../images/gallery/camping/campimg9.jpg"
import campimg10 from "../../images/gallery/camping/campimg10.jpg"
import campimg11 from "../../images/gallery/camping/campimg11.jpg"
import campimg12 from "../../images/gallery/camping/campimg12.jpg"



function App() {

    const homeImages = [home1,home2,home3,home4,home5,home6,home7,home8,home9,home10,home11,home12]

    const earthImages = [earthimg1, earthimg2, earthimg3, earthimg4, earthimg5, earthimg6, 
        earthimg7, earthimg8, earthimg9, earthimg10, earthimg11, earthimg12]
    
    const beachImages = [beachimg1,beachimg2,beachimg3,beachimg4,beachimg5,beachimg6,
        beachimg7,beachimg8,beachimg9,beachimg10,beachimg11,beachimg12]

    const waterImages = [waterimg1,waterimg2,waterimg3,waterimg4,waterimg5,waterimg6,
        waterimg7,waterimg8,waterimg9,waterimg10,waterimg11,waterimg12]

    const campImages = [campimg1,campimg2,campimg3,campimg4,campimg5,campimg6,
        campimg7,campimg8,campimg9,campimg10,campimg11,campimg12]

  return (
    <div className="whole-home-container">
        <div className="home-background">
            <div className="gal-collection">
                <div className="about-title">
                    <h1>MindHaven Gallery</h1>
                    <p>A Collection of Featured Photos from MindHaven School Inc</p>
                </div>
                <div className="gal-container">
                    <h1 className="gal-title">Student Life</h1>
                    <Gallerycont images={homeImages}/>
                </div>
                <br />
                <br />
                <div className="gal-container">
                    <h1 className="gal-title">Outdoor Camping</h1>
                    <Gallerycont images={campImages}/>
                </div>
                <br />
                <br />
                <div className="gal-container">
                    <h1 className="gal-title">Water Safety Exercises</h1>
                    <Gallerycont images={waterImages}/>
                </div>
                <br />
                <br />
                <div className="gal-container">
                    <h1 className="gal-title">Beach Clean Up</h1>
                    <Gallerycont images={beachImages} title=""/>
                </div>
                <br />
                <br />
                <div className="gal-container">
                    <h1 className="gal-title">Earth Day Celebration</h1>
                    <Gallerycont images={earthImages}/>
                </div>
                <br />
                <br />
            </div>
        </div>
    </div>
  );
}

export default App;
