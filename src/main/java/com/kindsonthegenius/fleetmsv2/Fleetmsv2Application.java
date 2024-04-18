package com.kindsonthegenius.fleetmsv2;

import com.kindsonthegenius.fleetmsv2.security.SpringSecurityAuditorAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class Fleetmsv2Application {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new SpringSecurityAuditorAware();
	}

	public static void main(String[] args) {
		SpringApplication.run(Fleetmsv2Application.class, args);
		System.setProperty("javax.net.ssl.trustStore", "/path/to/truststore.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "password");

	}

//	@EventListener(ApplicationEvent.class)
//	public void sendMail(){
//		senderService.sendEmail("kasubamuchese1@gmail.com",
//				"This is Subject",
//				"This the Body of the Email");
//	}

}
