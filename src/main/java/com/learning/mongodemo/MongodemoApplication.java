package com.learning.mongodemo;

import com.learning.mongodemo.product.dto.Product;
import com.learning.mongodemo.product.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class MongodemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			ProductRepository repository
	) {
		return args -> {
			var product = Product.builder()
					.name("iphone")
					.description("iphone")
					.build();
			repository.insert(product);
		};
	}
}
