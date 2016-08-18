package com.model;

public class User {
	
	private String firstName;
	private String lastName;
	private String deviceToken;
	private String notificationId;
	private String notificationCategory;
	private String notificationIdentifier;
	
	public String getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(String notificationId) {
		this.notificationId = notificationId;
	}
	public String getNotificationCategory() {
		return notificationCategory;
	}
	public void setNotificationCategory(String notificationCategory) {
		this.notificationCategory = notificationCategory;
	}
	public String getNotificationIdentifier() {
		return notificationIdentifier;
	}
	public void setNotificationIdentifier(String notificationIdentifier) {
		this.notificationIdentifier = notificationIdentifier;
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
	public String getDeviceToken() {
		return deviceToken;
	}
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
	

}
