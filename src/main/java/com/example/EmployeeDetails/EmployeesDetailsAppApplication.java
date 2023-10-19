package com.example.EmployeeDetails;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Employees API", version = "2.0", description = "Employees Information"))
@SpringBootApplication
public class EmployeesDetailsAppApplication {

    @Bean
    public ModelMapper modelmapper() {
	 return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeesDetailsAppApplication.class, args);
	}
}
