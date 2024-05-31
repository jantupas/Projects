import React, { useState, useEffect } from "react"
import { db } from "../../../firebase";
import { getDocs, collection, query, orderBy } from "firebase/firestore";
import "./announcementstyles.css"

async function fetchDataFromFirestore() {
    const q = query(collection(db, "announcements"), orderBy("date", "desc"))
    const querySnapshot = await getDocs(q)

    const data = []
    querySnapshot.forEach((doc) => {
        data.push({ id: doc.id, ...doc.data()})
    })

    return data
}

function Announcementcont() {
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
            {announcementData.map((announcement) => (
                <div key={announcement.id} className="announce-page-container">
                <h2 className="announcement-title">{announcement.title}</h2>
                <p className="announce-page-date">{announcement.date.toDate().toLocaleDateString()}</p>
                <p className="announce-page-description">{announcement.content}</p>
                </div>  
            ))}
            
        </div>
    )
}
export default Announcementcont