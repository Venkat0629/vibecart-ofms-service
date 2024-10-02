package com.nisum.vibe.cart.offers;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VibeCartOFMSApp {

    public static void main(String[] args) {
        SpringApplication.run(VibeCartOFMSApp.class, args);
    }

}
