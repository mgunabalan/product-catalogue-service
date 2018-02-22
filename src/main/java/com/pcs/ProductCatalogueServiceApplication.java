package com.pcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
//@ComponentScan(basePackages= {"com.globo.productcatalogue.controller"})
//@EnableJpaRepositories("com.globo.productcatalogue.repository")
//@EntityScan("com.globo.productcatalogue.model")
public class ProductCatalogueServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogueServiceApplication.class, args);
	}
}
