import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { collection, query, where, getDocs } from "firebase/firestore";
import { db } from "../../../firebase";
import "./admissionstyles.css";

function User() {
  const [email, setEmail] = useState("");
  const [refno, setRefNo] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const [applicantInfo, setApplicantInfo] = useState(null);
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const refNumber = parseInt(refno, 10);

      const q = query(
        collection(db, "applicant_information"),
        where("email", "==", email),
        where("refno", "==", refNumber)
      );

      const querySnapshot = await getDocs(q);

      if (querySnapshot.empty) {
        setErrorMessage("Incorrect email or reference number.");
        setApplicantInfo(null); 
      } else {
        querySnapshot.forEach((doc) => {
          setApplicantInfo(doc.data());
          navigate(`/userdash?email=${email}&refno=${refNumber}`);
        });
      }
    } catch (error) {
      console.error("Error logging in: ", error);
      setErrorMessage("An error occurred. Please try again.");
    }
  };

  const handleCloseError = () => {
    setErrorMessage("");
  };

  return (
    <div className="admin-log-container">
      <h2 className="admin-log-title">TRACK YOUR APPLICATION STATUS</h2>
      <div className="admin-login">
        <form className="admin-login-form" onSubmit={handleLogin}>
          <div className="admin-login-form-cont">
            <div className="login-content">
              <label className="admin-form-label">Email</label>
              <input
                type="email"
                required
                maxLength={100}
                className="admin-input"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
            </div>
            <div className="login-content">
              <label className="admin-form-label">Reference Number</label>
              <input
                type="text"
                required
                maxLength={100}
                className="admin-input"
                value={refno}
                onChange={(e) => setRefNo(e.target.value)}
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

export default User;
