package com.guernelli.calcoltriceweb1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;


@SpringBootApplication
public class CalcolatriceWeb1Application {

	public static void main(String[] args) {
		SpringApplication.run(CalcolatriceWeb1Application.class, args);
		

	}

	@PostConstruct
	public void check() {
	    System.out.println(">>> STO AVVIANDO CalcolatriceWeb-1 <<<");
	}

}
