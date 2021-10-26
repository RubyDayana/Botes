package com.usa.boat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages = {"com.usa.boat.entity"})
@SpringBootApplication
public class BoatApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoatApplication.class, args);
    }
}
