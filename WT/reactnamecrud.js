import React, { useState } from "react";
import './App.css';

function App() {
    const [name, setName] = useState('');
    const [spi, setSpi] = useState(''); // Keep SPI state
    const [savedNames, setSavedNames] = useState([]);
    const [editIndex, setEditIndex] = useState(-1);

    const editName = (index) => {
        const { name, spi } = savedNames[index];
        setName(name);
        setSpi(spi); // Set SPI for editing
        setEditIndex(index);
    };

    const newName = () => {
        setName('');
        setSpi(''); // Reset SPI
        setEditIndex(-1);
        alert("New button clicked! Form reset.");
    };

    const deleteName = (index) => {
        const updatedNames = savedNames.filter((_, i) => i !== index);
        setSavedNames(updatedNames);
        alert("Delete button clicked! Entry cleared.");
    };

    const saveName = () => {
        if (name) {
            if (editIndex >= 0) {
                // Update existing entry
                const updatedNames = savedNames.map((item, i) => (
                    i === editIndex ? { name, spi } : item
                ));
                setSavedNames(updatedNames);
                setEditIndex(-1);
                alert("Entry updated: " + name);
            } else {
                // Save new entry
                setSavedNames([...savedNames, { name, spi }]);
                alert("Entry saved: " + name);
            }
            setName('');
            setSpi(''); // Clear SPI
        } else {
            alert("Please enter a name to save.");
        }
    };

    return (
        <div className="form-container">
            <h2>Add or Remove Names</h2>
            <form id="myForm">
                <label htmlFor="name">Name:</label>
                <input 
                    type="text" 
                    id="name" 
                    name="name" 
                    value={name} 
                    onChange={(e) => setName(e.target.value)} 
                    required 
                />
                
                <label htmlFor="spi">SPI:</label>
                <input 
                    type="text" 
                    id="spi" 
                    name="spi" 
                    value={spi} 
                    onChange={(e) => setSpi(e.target.value)} 
                />
                <br /><br />
                <button type="button" onClick={newName}>New</button>
                <button type="button" onClick={saveName}>{editIndex >= 0 ? 'Update' : 'Save'}</button>
            </form>
            <h3>Saved Entries:</h3>
            <ul>
                {savedNames.map((savedItem, index) => (
                    <li key={index}>
                        {savedItem.name} - SPI: {savedItem.spi}
                        <button onClick={() => editName(index)}>Edit</button>
                        <button onClick={() => deleteName(index)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default App;
