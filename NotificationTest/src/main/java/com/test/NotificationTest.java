package com.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.model.User;
import com.notnoop.apns.APNS;
import com.notnoop.apns.PayloadBuilder;
import com.opt.notification.NotificationComponent;

public class NotificationTest extends NotificationComponent{

	public static void main(String[] args) {
		NotificationTest notTest = new NotificationTest();
		User user = new User();
		user.setDeviceToken("0b40e718957c57fd209710c78188acd54edcf16649f93f3fea6420f650d36e31");
		user.setFirstName("Preetam");
		user.setLastName("Bhat");
		user.setNotificationCategory("Test");
		user.setNotificationId("test");
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		notTest.pushNotification(userList, false, "buildpal");
	}
	
	
	@Override
	public PayloadBuilder constructPayload(User user) {
		PayloadBuilder payloadBuilder = APNS.newPayload();
		payloadBuilder = payloadBuilder.badge(1).sound("BuildPal.m4a").
		customField("category", user.getNotificationId()).
		customField("link_url","www.buildpal.com").
		alertBody("This is my first notification");
		return payloadBuilder;
		
	}
	
	@Override
	public InputStream getInputStream() {
		return this.getClass().getClassLoader().getResourceAsStream("BP_PN.p12");
	}
}
