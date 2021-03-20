package com.example.accessingdatamysql;

import com.example.accessingdatamysql.model.AddressDetails;
import com.example.accessingdatamysql.model.EOrders;
import com.example.accessingdatamysql.repository.AddressDetailsRepository;
import com.example.accessingdatamysql.repository.EOrdersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
//@RestController
public class AccessingDataMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMysqlApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(AddressDetailsRepository repo) {
		return args -> {
			AddressDetails a = new AddressDetails(1, "Home", "Seattle", "1212", "12321", "WA", "98104");
			repo.save(a);
		};
	}
	@Bean
	CommandLineRunner commandLineRunner2(EOrdersRepository repo) {
		return args -> {
			Date date = new Date(System.currentTimeMillis());;
			EOrders a = new EOrders(1, "1", "Ordered", "1212", date);
			repo.save(a);
		};
	}
}
