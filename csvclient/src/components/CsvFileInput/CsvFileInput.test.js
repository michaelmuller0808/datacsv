import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import CsvFileInput from './CsvFileInput';

describe('<CsvFileInput />', () => {
  test('it should mount', () => {
    render(<CsvFileInput />);

    const CsvFileInput = screen.getByTestId('CsvFileInput');

    expect(CsvFileInput).toBeInTheDocument();
  });
});