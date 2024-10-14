package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.LocationEntity;

/**
 * 
 */

public interface DataRepository {

	public Long count();
	
	public List<LocationEntity> getAllLocations();
	
}
