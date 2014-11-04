package com.roscode.dootoo.dtp.user.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.roscode.dootoo.dtp.model.Location;

public class User {

	@Id
	private String id; // email address
	private String password;
	
	private String firstName;
	private String lastName;
	private String prefZip;
	private List<Connection> connections;
	private Location currentLoc;
	
	public User() {
		// default constructor
	}
	
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return String.format("User[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPrefZip() {
		return prefZip;
	}

	public void setPrefZip(String prefZip) {
		this.prefZip = prefZip;
	}

	public List<Connection> getConnections() {
		return connections;
	}

	public void setConnections(List<Connection> connections) {
		this.connections = connections;
	}

	public Location getCurrentLoc() {
		return currentLoc;
	}

	public void setCurrentLoc(Location currentLoc) {
		this.currentLoc = currentLoc;
	}

}
