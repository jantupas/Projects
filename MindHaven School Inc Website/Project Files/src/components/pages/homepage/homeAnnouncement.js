import React, { useState, useEffect } from "react"
import { db } from "../../../firebase"
import { getDocs, collection, limit, query, orderBy } from "firebase/firestore"
import { Link } from "react-router-dom"
import "./homepage.css"

async function fetchDataFromFirestore() {
    const q = query(collection(db, "announcements"), orderBy("date", "desc"), limit(2))
    const querySnapshot = await getDocs(q)

    const data = []
    querySnapshot.forEach((doc) => {
        data.push({ id: doc.id, ...doc.data()})
    })

    return data
}

function Homeannounce (){
    const [announcementData, setAnnouncementData] = useState([])

    useEffect(() => {
        async function fetchData() {
            const data = await fetchDataFromFirestore()
            setAnnouncementData(data)
        }
        fetchData()
    }, [])
    return (
        <div>
        {announcementData.map((announcement, index) => (
            <div className="announcement-container">
            <div key={announcement.id} className="announcement-description">
                <h2 className="home-ann-title">{announcement.title}</h2>
                <p className="home-ann-date">{announcement.date.toDate().toLocaleDateString()}</p>
                <p className="home-ann-description">{announcement.content}</p>
                <Link to="../announcement" className="read-more">READ MORE</Link>
            </div>
            </div>
        ))}
        </div>
        
    )
}

export default Homeannounce