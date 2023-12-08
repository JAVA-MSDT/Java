package com.javamed.etl;

import com.javamed.etl.service.UserWebClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class EtlApplication implements ApplicationRunner {
    private final UserWebClientService userWebClientService;

    public static void main(String[] args) {
        SpringApplication.run(EtlApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {

        userWebClientService.saveUsers();
        System.out.println("================ Start of Returning users from DB ================");
        userWebClientService.getUsers().toIterable().forEach(System.out::println);
        System.out.println("================ End of Returning users from DB ================");

    }
}
