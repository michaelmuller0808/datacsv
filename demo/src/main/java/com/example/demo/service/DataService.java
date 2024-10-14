package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.LocationEntity;

public interface DataService {

	public Long count();
	
	public List<LocationEntity> getAllLocations();
	
}
