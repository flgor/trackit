package io.trackit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("io.trackit")
@EnableJpaRepositories(basePackages = "io.trackit.repository")
public class Application {
	//Test

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
