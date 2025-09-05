package com.example.AntraNotebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AntraNotebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(AntraNotebookApplication.class, args);
	}

}
