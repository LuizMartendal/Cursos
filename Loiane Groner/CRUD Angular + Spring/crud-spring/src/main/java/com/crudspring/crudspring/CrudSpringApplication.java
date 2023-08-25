package com.crudspring.crudspring;

import com.crudspring.crudspring.controller.HelloController;
import com.crudspring.crudspring.model.Course;
import com.crudspring.crudspring.repository.CourseRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

}
