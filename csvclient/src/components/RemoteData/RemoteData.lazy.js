import React, { lazy, Suspense } from 'react';

const LazyRemoteData = lazy(() => import('./RemoteData'));

const RemoteData = props => (
  <Suspense fallback={null}>
    <LazyRemoteData {...props} />
  </Suspense>
);

export default RemoteData;
