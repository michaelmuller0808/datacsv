import React from 'react';
import Papa from 'papaparse';
import PropTypes from 'prop-types';
import styles from './CsvFileInput.module.css';

const CsvFileInput = ({ onFileLoad }) => {
  const handleFileChange = (e) => {
    const file = e.target.files[0];
    
    if (file) {
      Papa.parse(file, {
        complete: (result) => {
          onFileLoad(result.data);
        },
        header: true,
        dynamicTyping: true,
        skipEmptyLines: true,
      });
    }
  };  return (
    <div>
      <input type="file" onChange={handleFileChange} />
    </div>
  );
};

CsvFileInput.propTypes = {};

CsvFileInput.defaultProps = {};

export default CsvFileInput;
