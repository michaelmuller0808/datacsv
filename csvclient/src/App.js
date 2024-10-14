import logo from './logo.svg';
import './App.css';
import CsvFileInput from './components/CsvFileInput/CsvFileInput';
import RemoteData from './components/RemoteData/RemoteData';
import React, { useState } from 'react';

function App() {
  const [data, setData] = useState([]);  const handleFileLoad = (csvData) => {
    setData(csvData);
  };
  return (
    <div className="App">
      <div>
        <h1>CSV Import in React.js</h1>
        <CsvFileInput onFileLoad={handleFileLoad} />
        <ul>
          {data.map((row, index) => (
            <li key={index}>{JSON.stringify(row)}</li>
          ))}
        </ul>
      </div>
      <div>
        <h1>Top locations close to the point</h1>
        <fetchData onFileLoad={handleFileLoad} />
        <ul>
          {data.map((row, index) => (
            <li key={index}>{JSON.stringify(row)}</li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default App;
