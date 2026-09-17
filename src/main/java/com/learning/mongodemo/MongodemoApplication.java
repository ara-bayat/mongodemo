package com.learning.mongodemo;

import com.learning.mongodemo.product.dto.Category2;
import com.learning.mongodemo.product.dto.Product;
import com.learning.mongodemo.product.repository.CategoryRepository;
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

//	@Bean
	public CommandLineRunner commandLineRunner(
			ProductRepository repository,
			CategoryRepository categoryRepository
	) {
		return _ -> {
			var category = Category2.builder()
					.name("smartphone")
					.description("Smartphone")
					.build();
			var category2 = Category2.builder()
					.name("mobile")
					.description("Mobile")
					.build();
			categoryRepository.save(category);
			categoryRepository.save(category2);
			var product = Product.builder()
					.name("iphone")
					.description("iphone")
					.category2(category2)
					.build();
			repository.insert(product);
		};
	}
}
