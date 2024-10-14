package com.example.demo.entity;

/**
 * 
 */

public class LocationEntity {

	private String locationid;
	
	private String location;
	
	private Double distance;
	
	public LocationEntity() {
	}

	public LocationEntity(String locationid, String location, Double distance) {
		super();
		this.locationid = locationid;
		this.location = location;
		this.distance = distance;
	}

	public String getLocationid() {
		return locationid;
	}

	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "LocationEntity [locationid=" + locationid + ", location=" + location + ", distance=" + distance
				+ ", getLocationid()=" + getLocationid() + ", getLocation()=" + getLocation() + ", getDistance()="
				+ getDistance() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
