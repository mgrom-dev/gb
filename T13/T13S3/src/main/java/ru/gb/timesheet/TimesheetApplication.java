package ru.gb.timesheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimesheetApplication {
	// тестирование приложения
	// http://localhost:8080/swagger-ui/index.html
	public static void main(String[] args) {
		SpringApplication.run(TimesheetApplication.class, args);
	}

}
