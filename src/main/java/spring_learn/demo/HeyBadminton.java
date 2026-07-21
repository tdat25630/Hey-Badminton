package spring_learn.demo;

import org.mapstruct.MapperConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperConfig
public class HeyBadminton {

	public static void main(String[] args) {
		SpringApplication.run(HeyBadminton.class, args);
	}

}
