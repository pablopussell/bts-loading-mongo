package com.bts.ingestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;

/**
 * @author mplanaguma
 *
 */
@SpringBootApplication
@EnableIntegration
@ImportResource({"classpath*:**/loading-integration.xml"})
public class DemoLoadMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoLoadMongoApplication.class, args);
	}
}
