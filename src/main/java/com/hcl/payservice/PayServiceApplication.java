package com.hcl.payservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/***********
 * 
 * @author vamsi
 * HDFC Payment Service (UPI, IMPS, NEFT)
 */


@EnableEurekaClient
@SpringBootApplication
public class PayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayServiceApplication.class, args);
	}

}
