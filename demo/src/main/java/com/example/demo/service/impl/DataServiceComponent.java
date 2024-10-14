package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.LocationEntity;
import com.example.demo.repository.impl.DataRepoComponent;
import com.example.demo.service.DataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataServiceComponent implements DataService {

	@Autowired
	private DataRepoComponent DataRepo;

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return DataRepo.count();
	}

	@Override
	public List<LocationEntity> getAllLocations() {
		// TODO Auto-generated method stub
		return DataRepo.getAllLocations();
	}
	
}
