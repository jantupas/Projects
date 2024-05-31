import React, { useState, useEffect } from "react"
import emailjs from "emailjs-com"
import "./contactstyles.css"

function Form() {
    const [isSubmitted, setIsSubmitted] = useState(false);
    const [formData, setFormData] = useState({
        firstName: "",
        lastName: "",
        email: "",
        phone: "",
        subject: "",
        message: ""
    });

    useEffect(() => {
        if (isSubmitted) {
            const timer = setTimeout(() => {
                setIsSubmitted(false);
            }, 3000);

            return () => clearTimeout(timer);
        }
    }, [isSubmitted]);

    function handleSubmit(event) {
        event.preventDefault();
        const isConfirmed = window.confirm("Are you sure you want to submit?");
        if (isConfirmed) {
            // Send email using EmailJS
            emailjs.send("service_nr6nnpa", "template_eyiz2yx", formData, "CoedYHg7AJoRl9Cmo")
                .then(() => {
                    setIsSubmitted(true);
                    setFormData({
                        firstName: "",
                        lastName: "",
                        email: "",
                        phone: "",
                        subject: "",
                        message: ""
                    });
                })
                .catch(error => console.error("Error sending email:", error));
        }
    }   

    function handleChange(event) {
        const { name, value } = event.target;
        setFormData({
            ...formData,
            [name]: value
        });
    }

    return (
        <div>
            <form className="contact-form" onSubmit={handleSubmit}>
                <div className="first-form">
                    <div className="form-content">
                        <label>*First Name</label>
                        <input 
                            type="text"
                            className="form-input"
                            maxLength={100}
                            name="firstName"
                            value={formData.firstName}
                            required
                            onChange={handleChange}
                        />
                    </div>
                    <div className="form-content">
                        <label>*Last Name</label>
                        <input 
                            type="text"
                            className="form-input"
                            maxLength={100}
                            name="lastName"
                            value={formData.lastName}
                            required
                            onChange={handleChange}
                        />
                    </div>
                    <div className="form-content">
                        <label>*Email</label>
                        <input 
                            type="email"
                            className="form-input"
                            maxLength={100}
                            name="email"
                            value={formData.email}
                            required
                            onChange={handleChange}
                        />
                    </div>
                    <div className="form-content">
                        <label>Phone</label>
                        <input 
                            type="tel"
                            className="form-input"
                            name="phone"
                            value={formData.phone}
                            onChange={handleChange}
                        />
                    </div>
                </div>
                <div className="second-form">
                    <div className="form2-content">
                        <label>*Subject</label>
                        <input 
                            type="text"
                            className="form2-input"
                            maxLength={100}
                            name="subject"
                            value={formData.subject}
                            required
                            onChange={handleChange}
                        />
                    </div>
                    <div className="form2-content">
                        <label>*Message</label>
                        <textarea 
                            id="form-message"
                            className="textarea-message"
                            rows="5"
                            name="message"
                            value={formData.message}
                            required
                            onChange={handleChange}
                        />
                    </div>
                </div>
                <div className="btn-container">
                    <button type="submit" className="submit-btn">Submit</button>
                </div>
            </form>
            {isSubmitted && (
                <div className="modal-container">
                    <div className="modal">
                        <div className="modal-content">
                            <p>Message has been sent!</p>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
}
export default Form;
