import React, { useState, useEffect } from "react";
import { useLocation } from "react-router-dom";
import { collection, query, where, getDocs } from "firebase/firestore";
import { db } from "../../../firebase";
import { Link } from "react-router-dom"
import Form from "../contact/Form"


function getStatusColor(status) {
    switch (status) {
      case "pending":
        return "status-pending";
      case "approved":
        return "status-approved";
      case "denied":
        return "status-denied";
      default:
        return "";
    }
  }
  
function UserDash() {
  const location = useLocation();
  const [applicantInfo, setApplicantInfo] = useState(null);

  useEffect(() => {
    const searchParams = new URLSearchParams(location.search);
    const email = searchParams.get("email");
    const refno = parseInt(searchParams.get("refno"), 10);

    const fetchData = async () => {
      try {
        const q = query(
          collection(db, "applicant_information"),
          where("email", "==", email),
          where("refno", "==", refno)
        );
        const querySnapshot = await getDocs(q);

        if (!querySnapshot.empty) {
          querySnapshot.forEach((doc) => {
            setApplicantInfo(doc.data());
          });
        }
      } catch (error) {
        console.error("Error fetching applicant information: ", error);
      }
    };

    fetchData();
  }, [location.search]);

  return (
    <div className="whole-contact-container">
        <div className="contact-background">
        <h2 className="user-dash-welcome">Greetings from MindHaven School Inc!</h2>
        {applicantInfo && (
            <div className="applicant-info-table">
            <h2 className="applicant-table-title">Applicant Information</h2>
            <div className="table-container">
            <table className="application-table">
                <thead>
                <tr>
                    <th className="app-table-title">First Name</th>
                    <th className="app-table-title">Middle Name</th>
                    <th className="app-table-title">Last Name</th>
                    <th className="app-table-title">Date of Birth</th>
                    <th className="app-table-title">Gender</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td className="app-table-content">{applicantInfo.firstname}</td>
                    <td className="app-table-content">{applicantInfo.middlename}</td>
                    <td className="app-table-content">{applicantInfo.lastname}</td>
                    <td className="app-table-content">{new Date(applicantInfo.dateofbirth.seconds * 1000).toLocaleDateString()}</td>
                    <td className="app-table-content">{applicantInfo.gender}</td>
                </tr>
                <tr>
                    <th className="app-table-title">Nationality</th>
                    <th className="app-table-title">Email</th>
                    <th className="app-table-title">Username</th>
                    <th className="app-table-title">Number</th>
                    <th className="app-table-title">Reference Number</th>
                </tr>
                <tr>
                    <td className="app-table-content">{applicantInfo.nationality}</td>
                    <td className="app-table-content">{applicantInfo.email}</td>
                    <td className="app-table-content">{applicantInfo.username}</td>
                    <td className="app-table-content">{applicantInfo.number}</td>
                    <td className="app-table-content">{applicantInfo.refno}</td>
                </tr>
                </tbody>
            </table>
            </div>
                <h2 className={`applicant-status-message ${getStatusColor(applicantInfo.status)}`}>
                Your Application Status is {applicantInfo.status && applicantInfo.status.toUpperCase()}
                </h2>
            </div>
        )}
        <div className="use-contact-form">
        <h2 className="user-contact-form-title">Send us a Message for any Concerns</h2>
        <p className="user-contact-form-desc">Fill up the form below.</p>
            <Form />
        </div>
        <div className="user-logout-container">
            <Link to="/homepage" className="user-logout">Log Out</Link>
        </div>
        </div>
    </div>
  );
}

export default UserDash;
