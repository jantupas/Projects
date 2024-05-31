import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { db } from "../../../firebase";
import { getDocs, collection, query, where } from "firebase/firestore";
import "./admissionstyles.css";

function Admin() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    // Query the 'admin' collection for the provided username
    const adminQuery = query(collection(db, "admin"), where("username", "==", username));
    const querySnapshot = await getDocs(adminQuery);

    // Check if username exists
    if (!querySnapshot.empty) {
      // Username exists, check password
      const adminData = querySnapshot.docs[0].data();
      if (adminData.password === password) {
        // Password matches, navigate to '/announcedash'
        navigate('/announcedash');
      } else {
        // Password does not match
        setErrorMessage("Incorrect password.");
      }
    } else {
      // Username does not exist
      setErrorMessage("Username does not exist.");
    }
  };

  const handleCloseError = () => {
    setErrorMessage("");
  };

  return (
    <div className="admin-log-container">
      <h2 className="admin-log-title">LOGIN AS ADMIN</h2>
      <div className="admin-login">
        <form className="admin-login-form" onSubmit={handleLogin}>
          <div className="admin-login-form-cont">
            <div className="login-content">
              <label className="admin-form-label">Username</label>
              <input
                type="text"
                required
                maxLength={100}
                className="admin-input"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
            </div>
            <div className="login-content">
              <label className="admin-form-label">Password</label>
              <input
                type="password"
                required
                maxLength={100}
                className="admin-input"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </div>
          </div>
          <div className="admin-log-btn-cont">
            <button className="admin-log-sbmt" type="submit">
              Login
            </button>
          </div>
        </form>
      </div>
      {errorMessage && (
        <div className="error-modal-overlay" onClick={handleCloseError}>
          <div className="error-modal">
            <p>{errorMessage}</p>
            <button onClick={handleCloseError}>Close</button>
          </div>
        </div>
      )}
    </div>
  );
}

export default Admin;
