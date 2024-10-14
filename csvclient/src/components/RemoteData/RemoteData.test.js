import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import RemoteData from './RemoteData';

describe('<RemoteData />', () => {
  test('it should mount', () => {
    render(<RemoteData />);

    const RemoteData = screen.getByTestId('RemoteData');

    expect(RemoteData).toBeInTheDocument();
  });
});