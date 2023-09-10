package com.arquisoft2023II.clinic_history_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ClinicHistoryMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicHistoryMsApplication.class, args);
	}

	@GetMapping("/")
	public GreetResponse greet(){
		return new GreetResponse("hello");
	}

	record GreetResponse(String greet){}
}
