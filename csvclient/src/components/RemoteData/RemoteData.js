import React, {useEffect,useState} from 'react';
import { useQuery } from '@tanstack/react-query';
import PropTypes from 'prop-types';
import styles from './RemoteData.module.css';

const RemoteData = () => {

  const { data: locations, isLoading, error } = useQuery({
    queryFn: () =>
      fetch('http://localhost:9030/data/top?count=500&lat1=37.74540642941645&lon1=-122.39008122484672', {mode: 'no-cos'}).then(
        (res) => res.json()
      ),
    queryKey: ['comments'],
  });

  // Show a loading message while data is fetching
  if (isLoading) {
    return <h2>Loading...</h2>;
  }

  // to handle error
  if (error) {
    return <div className="error">Error: error fetching</div>
  }

 return (
  <div>
  {locations.map((location) => (
    <h2 key={location.locationid} className="location">
      {location.locationid}.
      {location.location}.
      {location.distance}
    </h2>
  ))}
</div>
);
};
RemoteData.propTypes = {};

RemoteData.defaultProps = {};

export default RemoteData;
