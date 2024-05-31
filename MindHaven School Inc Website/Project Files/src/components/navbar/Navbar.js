import React, { useState } from "react";
import { Link } from "react-router-dom";
import "./navbar.css";
import logo from "./logo.png";

function Nav() {
  const [isMenuOpen, setIsMenuOpen] = useState(false);

  const toggleMenu = () => {
    setIsMenuOpen(!isMenuOpen);
  };

  return (
    <nav className="nav-bar">
      <img src={logo} alt="mindhaven logo" className="nav-logo" />
      <h2 className="nav-title">MINDHAVEN SCHOOL INC</h2>
      <div className={`page-link ${isMenuOpen ? "open" : ""}`}>
        <div className="burger-menu" onClick={toggleMenu}>
          <div className="line"></div>
          <div className="line"></div>
          <div className="line"></div>
        </div>
        <ul>
          <li>
            <Link to="./homepage" className="page" onClick={toggleMenu}>
              Home
            </Link>
          </li>
          <li>
            <Link to="./announcement" className="page" onClick={toggleMenu}>
              Announcement
            </Link>
          </li>
          <li>
            <Link to="./about" className="page" onClick={toggleMenu}>
              About Us
            </Link>
          </li>
          <li>
            <Link to="./admission" className="page" onClick={toggleMenu}>
              Join Us
            </Link>
          </li>
          <li>
            <Link to="./contact" className="page" onClick={toggleMenu}>
              Contact Us
            </Link>
          </li>
          <li>
            <Link to="./gallery" className="page" onClick={toggleMenu}>
              Gallery
            </Link>
          </li>
        </ul>
      </div>
    </nav>
  );
}

export default Nav;
