import React from "react";
import { Link } from "react-router-dom";
import "./footer.css";

function Foot() {
  return (
    <footer className="footer">
      <div className="footer-container">
        <div className="footer-section">
          <h2>SCHOOL</h2>
          <ul>
            <li><Link to="./homepage" className="footer-item">Home</Link></li>
            <li><Link to="./announcement" className="footer-item">Announcement</Link></li>
            <li><Link to="./admission" className="footer-item">Admission</Link></li>
          </ul>
        </div>
        <div className="footer-section">
          <h2>ABOUT US</h2>
          <ul>
            <li><Link to="./about#vismis" className="footer-item">Mission & Vision</Link></li>
            <li><Link to="./about" className="footer-item">School Background</Link></li>
            <li><Link to="./about" className="footer-item">Faculty and Staff</Link></li>
          </ul>
        </div>
        <div className="footer-section">
          <h2>CONTACT US</h2>
          <ul>
            <li><Link to="./contact" className="footer-item">Fuentes Subd., Arnaldo Boulevard , Roxas City, Philippines</Link></li>
            <li><Link to="./contact" className="footer-item">(036) 621 1383</Link></li>
            <li><Link to="./contact" className="footer-item">mindhavenschool@gmail.com</Link></li>
            <li>
              <a href="https://www.facebook.com/mindhavenschoolroxas" target="_blank" rel="noopener noreferrer" className="footer-item">
                Facebook
              </a>
            </li>
          </ul>
        </div>
      </div>
      <hr />
      <div className="footer-bottom">
        <p>© 2024 MindHaven School Inc.</p>
        <p>All rights reserved.</p>
      </div>
    </footer>
  );
}

export default Foot;
