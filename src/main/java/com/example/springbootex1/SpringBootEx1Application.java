package com.example.springbootex1;

import com.example.springbootex1.model.Product;
import com.example.springbootex1.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.stream.IntStream;

@SpringBootApplication
public class SpringBootEx1Application {

    private static final Random RANDOM = new Random(1000);

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootEx1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEx1Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(final ProductService productService) {
        return args -> {
            IntStream.range(0, 50)
                    .forEach(id ->  productService.create(new Product("The product #" + id, RANDOM.nextDouble() * 100)));
            LOGGER.info("The default products were successfully created!");
        };
    }

}
