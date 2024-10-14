package com.example.demo.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.LocationEntity;
import com.example.demo.repository.DataRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Transactional
@Repository
public class DataRepoComponent implements DataRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from DATACSV.data";
		Query q = em.createNativeQuery(sql);
		Long result = (Long) q.getSingleResult();
		return result;
	}

	@Override
	public List<LocationEntity> getAllLocations() {
		// TODO Auto-generated method stub
		String sql = "select locationid, location from DATACSV.data";
		Query q = em.createNativeQuery(sql);
		List<Object[]> rows = q.getResultList();
		List<LocationEntity> locations = new ArrayList<LocationEntity>();
		for(Object[] row : rows){
			LocationEntity location = new LocationEntity();
			location.setLocationid((row[0].toString()));
			location.setLocation(row[1].toString());
			locations.add(location);
		}
		return locations;
	}
	
}
