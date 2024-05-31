import React from "react"
import "./admissionstyles.css"
import { collection, addDoc } from "firebase/firestore"
import { db } from "../../../firebase"
import { useState, useEffect } from 'react'
import emailjs from "emailjs-com"

function Personal () {

    const [firstname, setFirstName] = useState('');
    const [middlename, setMiddleName] = useState('');
    const [lastname, setLastName] = useState('');
    const [dateofbirth, setDateOfBirth] = useState('');
    const [gender, setGender] = useState('');
    const [nationality, setNationality] = useState('');
    const [email, setEmail] = useState('');
    const [username, setUsername] = useState('');
    const [number, setNumber] = useState('');
    const [submissionMessage, setSubmissionMessage] = useState('');

    useEffect(() => {
        if (submissionMessage) {
            
            const timer = setTimeout(() => {
                setSubmissionMessage('');
            }, 3000); 

            return () => clearTimeout(timer);
        }
    }, [submissionMessage]);

    const generateRandomNumber = () => {
        return Math.floor(1000000000 + Math.random() * 9000000000);
    };

    const sendEmail = async (recipientEmail, refno) => {
        try {
            await emailjs.send(
                'service_nr6nnpa', 
                'template_807rgfv', 
                { to_email: recipientEmail, refno: refno }, 
                'CoedYHg7AJoRl9Cmo' 
            );
            console.log('Email sent successfully!');
        } catch (error) {
            console.error('Error sending email:', error);
        }
    };
    
    const sendSMS = async (refno) => {
        const myHeaders = new Headers();
        myHeaders.append("Authorization", "App 052fd6070330ce93dfd7ebf7dc348f2c-19f3d2e8-ff84-4491-a845-2090788b3830");
        myHeaders.append("Content-Type", "application/json");
        myHeaders.append("Accept", "application/json");

        const message = `Thank you for your interest in joining us at MindHaven School Inc. We have successfully received your application with reference number ${refno}. We will be in contact with you soon regarding your application via email. You may view the status of your application through the user dashboard. Thank you and have a good day.`;
        const formattedNumber = number.startsWith("63") ? number : `63${number}`;

        const raw = JSON.stringify({
            "messages": [
                {
                    "destinations": [{"to": formattedNumber}],
                    "from": "MindHaven School Inc.",
                    "text": message
                }
            ]
        });

        const requestOptions = {
            method: "POST",
            headers: myHeaders,
            body: raw,
            redirect: "follow"
        };

        try {
            await fetch("https://rgz3xy.api.infobip.com/sms/2/text/advanced", requestOptions);
        } catch (error) {
            console.error("Error sending SMS: ", error);
        }
    };

    const handlePerSubmit = async (e) => {
        e.preventDefault();

        const isConfirmed = window.confirm("Are you sure you want to submit this application?");
        if (!isConfirmed) {
            return;
        }
        
        const refno = generateRandomNumber()

        try {
          const docRef = await addDoc(collection(db, "applicant_information"), {
            firstname: firstname,
            middlename: middlename,
            lastname: lastname,
            dateofbirth: new Date(dateofbirth),
            gender: gender,
            nationality: nationality,
            email: email,
            username: username,
            number: number,
            status: "pending",
            refno: refno
          });

          await sendSMS(refno);
          await sendEmail(email, refno);
          
          setSubmissionMessage('We have received your submission. Thank you!');
          setFirstName('');
          setMiddleName('');
          setLastName('');
          setDateOfBirth('');
          setGender('');
          setNationality('');
          setEmail('');
          setUsername('');
          setNumber('');
    
        } catch (error) {
          console.error("Error adding document: ", error);
          setSubmissionMessage('There was an error processing your submission. Please try again.');
        }
      };

    return (
        <div className="personal-form-container">
            <h1 className="per-form-title">Personal Information</h1>
            <p className="dept-desc">Fill up the form to apply.</p>
            <form className="personal-form" onSubmit={handlePerSubmit}>
                <div className="per-form-content">
                    <div className="per-form-con">
                        <label className="personal-label">*First Name</label>
                        <input 
                            type="text"
                            className="personal-form-in"
                            maxLength={100}
                            required
                            value={firstname}
                            onChange={(e) => setFirstName(e.target.value)}
                        />
                    </div>
                    <div className="per-form-con">
                        <label className="personal-label">Middle Name</label>
                        <input 
                            type="text"
                            className="personal-form-in"
                            maxLength={100}
                            value={middlename}
                            onChange={(e) => setMiddleName(e.target.value)}                            
                        />
                    </div>
                    <div className="per-form-con">
                        <label className="personal-label">*Last Name</label>
                        <input 
                            type="text"
                            className="personal-form-in"
                            maxLength={100}
                            required
                            value={lastname}
                            onChange={(e) => setLastName(e.target.value)}
                        />
                    </div>
                    <div className="per-form-con">
                        <label className="personal-label">*Date of Birth</label>
                        <input 
                            type="date"
                            className="personal-form-in"
                            required
                            value={dateofbirth}
                            onChange={(e) => setDateOfBirth(e.target.value)}
                        />
                    </div>
                    <div className="per-form-con">
                        <label className="personal-label">*Gender</label>
                        <select id="gender" name="gender" className="personal-select" required value={gender} onChange={(e) => setGender(e.target.value)}>
                            <option value=""></option>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                        </select>
                    </div>
                    <div className="per-form-con">
                        <label className="personal-label">*Nationality</label>
                        <select id="nationality" name="nationality" className="personal-select" required value={nationality} onChange={(e) => setNationality(e.target.value)}>
                            <option value=""></option>
                            <option value="Afghan">Afghan</option>
                            <option value="Albanian">Albanian</option>
                            <option value="Algerian">Algerian</option>
                            <option value="Argentinian">Argentinian</option>
                            <option value="Australian">Australian</option>
                            <option value="Austrian">Austrian</option>
                            <option value="Bangladeshi">Bangladeshi</option>
                            <option value="Brazilian">Brazilian</option>
                            <option value="Canadian">Canadian</option>
                            <option value="Chinese">Chinese</option>
                            <option value="Egyptian">Egyptian</option>
                            <option value="Filipino">Filipino</option>
                            <option value="French">French</option>
                            <option value="German">German</option>
                            <option value="Indian">Indian</option>
                            <option value="Indonesian">Indonesian</option>
                            <option value="Italian">Italian</option>
                            <option value="Japanese">Japanese</option>
                            <option value="Mexican">Mexican</option>
                            <option value="Russian">Russian</option>
                            <option value="Others">Others</option>
                        </select>
                    </div>
                    <div className="per-form-con">
                        <label className="personal-label">*Parent/Guardian Email</label>
                        <input 
                            type="email"
                            className="personal-form-in"
                            maxLength={100}
                            required
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                        />
                    </div>
                    <div className="per-form-con">
                        <label className="personal-label">Parent/Guardian Facebook Username</label>
                        <input 
                            type="text"
                            className="personal-form-in"
                            maxLength={100}
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                        />
                    </div>
                    <div className="per-form-con">
                        <label className="personal-label">*Mobile Number</label>
                        <input 
                            type="tel"
                            className="personal-form-in"
                            required
                            value={number}
                            onChange={(e) => setNumber(e.target.value)}
                        />
                    </div>
                </div>
                <div className="per-btn-container">
                <button className ="per-submit-btn" type="submit">Submit</button>
                </div>
            </form>
            <div className={`submission-message ${submissionMessage ? 'show' : ''}`}>
                {submissionMessage}
            </div>
        </div>
    )
}

export default Personal