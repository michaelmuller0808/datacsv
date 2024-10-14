import React, { lazy, Suspense } from 'react';

const LazyCsvFileInput = lazy(() => import('./CsvFileInput'));

const CsvFileInput = props => (
  <Suspense fallback={null}>
    <LazyCsvFileInput {...props} />
  </Suspense>
);

export default CsvFileInput;
