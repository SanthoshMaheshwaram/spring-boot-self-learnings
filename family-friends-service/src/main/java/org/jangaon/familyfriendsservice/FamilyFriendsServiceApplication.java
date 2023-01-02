package org.jangaon.familyfriendsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class FamilyFriendsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilyFriendsServiceApplication.class, args);
	}

}