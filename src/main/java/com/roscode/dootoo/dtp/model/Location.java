package com.roscode.dootoo.dtp.model;

public class Location {
	
	private Double latitude;
	private Double longitude;
	
	public Location() {
		// default constructor
	}
	
	public Location(Double lat, Double lon) {
		this.latitude = lat;
		this.longitude = lon;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
