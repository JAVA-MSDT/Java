package com.javamed.etl;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class EtlApplication implements ApplicationRunner {
    private final UserWebClientService userWebClientService;
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(EtlApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {

        userWebClientService.saveUsers();
        User user = userRepository.findByLogin("nitay").block();
        System.out.println("User:: " + user);
        userWebClientService.getUsers().toIterable().forEach(System.out::println);

    }
}
