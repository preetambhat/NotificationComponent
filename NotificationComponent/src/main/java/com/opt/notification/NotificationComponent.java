package com.opt.notification;

import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.model.User;
import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import com.notnoop.apns.PayloadBuilder;

@Component
public class NotificationComponent {

	private static final Logger logger = Logger.getLogger(NotificationComponent.class);

	public void pushNotification(List<User> userList,boolean productionMode,String password) {
		ApnsService service = null;
		InputStream certStream = getInputStream();
		if(productionMode){
			logger.info("Certificate loaded in Production Mode : ");
			service = APNS.newService().withCert(certStream,password).withProductionDestination().build();
		}else{
			logger.info("Certificate loaded in Development Mode :");
			service = APNS.newService().withCert(certStream,password).withSandboxDestination().build();
		}
		service.start();
		logger.info("NotificationComponent : "+userList.size());
		for(User user : userList){
			try {
				if(user != null && user.getDeviceToken() != null && !user.getDeviceToken().equals("")){
					PayloadBuilder payloadBuilder = constructPayload(user);
					if (payloadBuilder.isTooLong()) {
						payloadBuilder = payloadBuilder.shrinkBody();
					}
					String payload = payloadBuilder.build();
					String token = user.getDeviceToken();
					service.push(token, payload);
					System.out.println("Device token : "+ user.getDeviceToken()+" : "+payload);
				}
			}catch(Exception e){
				e.printStackTrace();
				logger.error("Notification push failed for : "+ user.getFirstName()+" with profileId : "+user.getNotificationId());
				logger.error("Exception : "+e.getMessage());
			}
		}
	}
	
	public InputStream getInputStream() {
		return this.getClass().getClassLoader().getResourceAsStream("");
	}

	public PayloadBuilder constructPayload(User user){
		return APNS.newPayload();
	}
}
