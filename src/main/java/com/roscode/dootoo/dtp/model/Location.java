package com.roscode.dootoo.dtp.model;

public class Location {
	
	private Double x; // latitude
	private Double y; // longitude
	
	public Location() {
		// default constructor
	}
	
	public Location(Double lon, Double lat) {
		this.x = lon;
		this.y = lat;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}
	
}
