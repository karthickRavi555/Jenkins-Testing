package com.sensiple.drm.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;



/**
 * @author saravanan.k
 *
 */
@EnableCaching
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableDiscoveryClient
@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AccountManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountManagementApplication.class, args);
	}
}
