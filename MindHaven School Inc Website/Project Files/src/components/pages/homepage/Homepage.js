import React from "react"
import { Link } from "react-router-dom"

import "./homepage.css"
import "../gallery/gallerystyles.css"
import Homeannounce from "./homeAnnouncement"
import Homenews from "./homeNews"
import Map from "../contact/Map"
import Carousell from "./Carousell"
import image1 from "./image1.jpg"

import homeimg1 from "../../images/home/homeimg1.jpg"
import homeimg2 from "../../images/home/homeimg2.jpg"
import homeimg3 from "../../images/home/homeimg3.jpg"
import homeimg4 from "../../images/home/homeimg4.jpg"
import homeimg5 from "../../images/home/homeimg5.jpg"
import homeimg6 from "../../images/home/homeimg6.jpg"

import Gallerycont from "../gallery/Gallerycont"

import campimg1 from "../../images/gallery/camping/campimg1.jpg"
import campimg2 from "../../images/gallery/camping/campimg2.jpg"
import campimg3 from "../../images/gallery/camping/campimg3.jpg"
import campimg4 from "../../images/gallery/camping/campimg4.jpg"

import beachimg1 from "../../images/gallery/beach-clean-up/beachimg1.jpg"
import beachimg3 from "../../images/gallery/beach-clean-up/beachimg3.jpg"
import beachimg7 from "../../images/gallery/beach-clean-up/beachimg7.jpg"
import beachimg12 from "../../images/gallery/beach-clean-up/beachimg12.jpg"

import home1 from "../../images/gallery/home/home1.jpg"
import home2 from "../../images/gallery/home/home2.jpg"
import home3 from "../../images/gallery/home/home3.jpg"
import home4 from "../../images/gallery/home/home4.jpg"

import earthimg1 from "../../images/gallery/earth-day/earthimg1.jpg"
import earthimg2 from "../../images/gallery/earth-day/earthimg2.jpg"
import earthimg3 from "../../images/gallery/earth-day/earthimg3.jpg"
import earthimg4 from "../../images/gallery/earth-day/earthimg4.jpg"

import waterimg1 from "../../images/gallery/water-safety-exercises/waterimg1.jpg"
import waterimg3 from "../../images/gallery/water-safety-exercises/waterimg3.jpg"
import waterimg4 from "../../images/gallery/water-safety-exercises/waterimg4.jpg"
import waterimg5 from "../../images/gallery/water-safety-exercises/waterimg5.jpg"


function Homepage (){
    const images = [homeimg5,homeimg1,homeimg2,homeimg3,homeimg4,homeimg6]
    const homeGal = [home1,home2,home3,home4,campimg1,campimg2,campimg3,campimg4,waterimg1,waterimg3,waterimg4,waterimg5,
        beachimg1,beachimg3,beachimg7,beachimg12,earthimg1,earthimg2,earthimg3,earthimg4]
    return (
        <div className="whole-home-container">
            <div className="home-background">
            <div className="home-welcome-image">
                    <img src={image1} alt="welcome" className="welcome-image"/>
                </div>
                <div className="home-welcome">
                    <h1>A Warm and Hearty Welcome to <br /> MindHaven School Inc</h1>
                    <p>A place to learn, laugh, and love, MindHaven School Inc has 30+ years of experience as a progressive, play-based, and brain-based school.</p>
                </div>
                <div className="image-carousell-home">
                    <Carousell images={images}/>
                </div>
                <div className="home-title">
                    <h1>Featured Announcements</h1>
                    <p>The featured announcements provided by the school.</p>
                </div>
                <div className="home-anns">
                    <Homeannounce/>
                </div>
                <div className="home-title">
                    <h1>Latest News and Events</h1>
                    <p>The latest news and events provided by the school.</p>
                </div>
                <div className="home-anns">
                    <Homenews/>
                </div>
                <div className="home-title">
                    <h1>Gallery</h1>
                    <p>Featured photos from the school.</p>
                </div>
                <div className="gal-container">
                    <Gallerycont images={homeGal} title=""/>
                </div>
                <div className="home-title">
                    <h1>Visit Our Location</h1>
                    <p>You can visit us by using the map to see our location.</p>
                </div>
                <div className="home-map">
                    <Map />
                </div>
            </div>
        </div>
    )
}
export default Homepage