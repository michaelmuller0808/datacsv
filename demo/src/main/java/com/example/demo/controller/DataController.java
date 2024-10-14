package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.example.demo.config.GlobalConstraints;
import com.example.demo.entity.LocationEntity;
import com.example.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 
 */
@RestController
@RequestMapping("/data")
public class DataController {
	
	@Autowired
	private DataService DataSrv;

	@RequestMapping(value = { "/count" }, method = RequestMethod.GET)
	public String countRows(HttpServletRequest request){
		return String.valueOf(DataSrv.count());
	}
	
	@RequestMapping(value = { "/top" }, method = RequestMethod.GET)
	public List<LocationEntity> cloesTopFive(HttpServletRequest request){
		Double lat1 = Double.valueOf(request.getParameter("lat1")); 
		Double lon1 = Double.valueOf(request.getParameter("lon1"));
		Integer count = Integer.valueOf(request.getParameter("count"));
		List<LocationEntity> locations = DataSrv.getAllLocations();
		for (int i = 0; i < locations.size(); i ++) {
			String[] location = locations.get(i).getLocation().substring(1, locations.get(i).getLocation().length() - 1).split(",");
			Double lat2 = Double.valueOf(location[0]);
			Double lon2 = Double.valueOf(location[1]);
			locations.get(i).setDistance(calculateDistance(lat1, lon1, lat2, lon2));
		}
		Collections.sort(locations , new Comparator<LocationEntity>() {
		    @Override
		    public int compare(LocationEntity c1, LocationEntity c2) {
		        return Double.compare(c1.getDistance(), c2.getDistance());
		    }
		});
		List<LocationEntity> result = new ArrayList<LocationEntity>();
		if (count > locations.size()) {
			count = locations.size();
		}
		for (int t = 0; t < count; t ++) {
			result.add(locations.get(t));
		}
		return result;
	}
	
	private Double calculateDistance(Double lat1, Double lon1, Double lat2, Double lon2) {
		Double lat1Rad = Math.toRadians(lat1);
		Double lat2Rad = Math.toRadians(lat2);
		Double lon1Rad = Math.toRadians(lon1);
		Double lon2Rad = Math.toRadians(lon2);
		Double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
		Double y = (lat2Rad - lat1Rad);
		Double distance = Math.sqrt(x * x + y * y) * GlobalConstraints.EARTH_RADIUS;
	    return distance;
	}
	
}
