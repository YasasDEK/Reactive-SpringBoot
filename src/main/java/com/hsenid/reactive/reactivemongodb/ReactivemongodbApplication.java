package com.hsenid.reactive.reactivemongodb;

import com.hsenid.reactive.reactivemongodb.model.Employee;
import com.hsenid.reactive.reactivemongodb.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ReactivemongodbApplication {

	@Bean
	CommandLineRunner employees(EmployeeRepository employeeRepository) {
		return args -> {
			employeeRepository.deleteAll().subscribe(null,null,() ->{
				Stream.of(new Employee(UUID.randomUUID().toString(),"Yasas",23000L),
						new Employee(UUID.randomUUID().toString(),"Dilshan",30000L),
						new Employee(UUID.randomUUID().toString(),"Ekanayaka",55000L)
				).forEach(employee -> {
					employeeRepository.save(employee).subscribe(System.out::println);
				});
			});
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ReactivemongodbApplication.class, args);
		System.out.println("Hello World");
	}

}
