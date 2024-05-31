import React, { useState } from "react";
import "./gallerystyles.css";

function Gallerycont({ images }) {
  const [selectedImage, setSelectedImage] = useState(null);

  const handleImageClick = (index) => {
    setSelectedImage(index);
  };

  const handleCloseClick = () => {
    setSelectedImage(null);
  };

  return (
    <div className="gallery">
      <div className="gallery-cont">
        {images.map((image, index) => (
          <img
            key={index}
            src={image}
            alt={`image-${index}`}
            className="gal-img"
            onClick={() => handleImageClick(index)}
          />
        ))}
      </div>
      {selectedImage !== null && (
        <div className="overlay" onClick={handleCloseClick}>
          <img
            src={images[selectedImage]}
            alt={`image-${selectedImage}`}
            className="enlarged-img"
          />
          <span className="close-btn">&times;</span>
        </div>
      )}
    </div>
  );
}

export default Gallerycont;
