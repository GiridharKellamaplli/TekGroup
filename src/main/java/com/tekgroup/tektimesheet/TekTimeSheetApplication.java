package com.tekgroup.tektimesheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.tekgroup.tektimesheet")
public class TekTimeSheetApplication {

	public static void main(String[] args) {
		SpringApplication.run(TekTimeSheetApplication.class, args);
	}
}
