package com.roscode.dootoo.dtp.user.model;

import java.util.ArrayList;
import java.util.List;


public class Connection {

	private String conn_id; // email
	
	private List<String> groups = new ArrayList<String>();

	public String getConn_id() {
		return conn_id;
	}

	public void setConn_id(String conn_id) {
		this.conn_id = conn_id;
	}

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}
	
	public void addGroup(String group) {
		this.groups.add(group);
	}
	
}
