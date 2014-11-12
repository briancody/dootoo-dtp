package com.roscode.dootoo.dtp.happening.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.roscode.dootoo.dtp.user.model.User;

public class Happening {
	
	@Id
	private String id; // mongo generated id
	
	private String title;
	private String description;
	
	@DBRef(lazy = true)
	private User host;
	
	private String address;
	private String city;
	private String state;
	private Integer zip;
	@GeoSpatialIndexed(type=GeoSpatialIndexType.GEO_2D)
	private Point loc;
	
	@Indexed
	private String[] tags;
	private String[] assets;
	
	@DBRef(lazy = true)
	private List<User> invitees = new ArrayList<User>();
	
	@DBRef(lazy = true)
	private List<User> attendees = new ArrayList<User>();
	
	private Boolean invitationOnly = false;
	private Date startTime;
	private Date endTime;
	
	@CreatedBy
	private String createdBy;
	@CreatedDate
	private Date createDate;
	private String modifiedBy;
	private Date modifiedDate;
	
	public Happening() {
		// default constructor
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	
	}
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public Integer getZip() {
		return zip;
	}
	
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	
	public Point getLoc() {
		return loc;
	}

	public void setLoc(Point loc) {
		this.loc = loc;
	}

	public String[] getTags() {
		return tags;
	}
	
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	
	public String[] getAssets() {
		return assets;
	}
	
	public void setAssets(String[] assets) {
		this.assets = assets;
	}
	
	public List<User> getInvitees() {
		return invitees;
	}

	public void setInvitees(List<User> invitees) {
		this.invitees = invitees;
	}
	
	public void addInvitee(User invitee) {
		this.invitees.add(invitee);
	}

	public List<User> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}
	
	public void addAttendee(User attendee) {
		this.attendees.add(attendee);
	}

	public Boolean getInvitationOnly() {
		return invitationOnly;
	}
	
	public void setInvitationOnly(Boolean invitationOnly) {
		this.invitationOnly = invitationOnly;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getModifiedBy() {
		return modifiedBy;
	}
	
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public Date getModifiedDate() {
		return modifiedDate;
	}
	
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
