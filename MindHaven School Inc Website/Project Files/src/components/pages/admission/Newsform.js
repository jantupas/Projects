import React, { useState } from "react";
import "../contact/contactstyles.css";
import { collection, addDoc } from "firebase/firestore";
import { db } from "../../../firebase";

function Newsform() {
  const [title, setTitle] = useState('');
  const [date, setDate] = useState('');
  const [content, setContent] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Display confirmation message
    const isConfirmed = window.confirm("Are you sure you want to submit this announcement?");
    if (!isConfirmed) {
      return;
    }

    try {
      const docRef = await addDoc(collection(db, "announcements"), {
        title: title,
        date: new Date(date),
        content: content
      });

      setTitle('');
      setDate('');
      setContent('');
      window.location.reload();

    } catch (error) {
      console.error("Error adding document: ", error);
    }
  };

  return (
    <div>
      <form className="add-news-form" onSubmit={handleSubmit}>
        <h1 className="add-title"> ADD NEW ANNOUNCEMENT</h1>
        <label className="news-form-label">Title</label>
        <input 
          type="text"
          className="news-form-input"
          maxLength={100}
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        
        <label className="news-form-label">Date</label>
        <input 
          type="datetime-local"
          className="news-form-input"
          value={date}
          onChange={(e) => setDate(e.target.value)}
        />
        
        <label className="news-form-label">Content</label>
        <textarea 
          id="news-content" 
          className="textarea-message" 
          rows="5"
          value={content}
          onChange={(e) => setContent(e.target.value)}
        />
        <div className="btn-container">
          <button className ="submit-btn" type="submit">Submit</button>
        </div>
      </form>
    </div>
  );
}

export default Newsform;
