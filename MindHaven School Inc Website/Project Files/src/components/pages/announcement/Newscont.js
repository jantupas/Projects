import React, { useState, useEffect } from "react"
import { db } from "../../../firebase";
import { getDocs, collection, query, orderBy } from "firebase/firestore";
import "./announcementstyles.css"

async function fetchDataFromFirestore() {
    const q = query(collection(db, "news"), orderBy("date", "desc"))
    const querySnapshot = await getDocs(q)

    const data = []
    querySnapshot.forEach((doc) => {
        data.push({ id: doc.id, ...doc.data()})
    })

    return data
}

function Newscont() {
    const [newsData, setNewsData] = useState([])

    useEffect(() => {
        async function fetchData() {
            const data = await fetchDataFromFirestore()
            setNewsData(data)
        }
        fetchData()
    }, [])
    return (
        <div>
            {newsData.map((news) => (
                <div key={news.id} className="announce-page-container">
                <h2 className="announcement-title">{news.title}</h2>
                <p className="announce-page-date">{news.date.toDate().toLocaleDateString()}</p>
                <p className="announce-page-description">{news.content}</p>
            </div>
            ))}
            
        </div>
    )
}
export default Newscont