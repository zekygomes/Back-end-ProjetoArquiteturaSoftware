package com.diskrango;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
/**
 * 
 * @author Zeky and Maurício
 *
 */
@EnableWebMvc
@SpringBootApplication
public class DiskRangoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiskRangoApplication.class, args);
	}
}
