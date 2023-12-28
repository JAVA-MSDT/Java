package com.javamed.etl.service;

import com.javamed.etl.modal.User;
import com.javamed.etl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserWebClientService {

    private final UserRepository userRepository;
    @Value("${base.api.url}")
    private String baseUrl;
    @Value("${users.resource}")
    private String users;

    public UserWebClientService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> getUsers() {
        return userRepository.findAll();
    }

    public void saveUsers() {
        WebClient webClient = WebClient.builder().baseUrl(baseUrl).build();
        webClient.get()
                .uri(users)
                .retrieve()
                .onStatus(httpStatusCode -> (httpStatusCode.is4xxClientError() || httpStatusCode.is5xxServerError())
                        , clientResponse -> Mono.error(new RuntimeException("Failed to fetch users. Status: " + clientResponse.statusCode())))
                .bodyToFlux(User.class)
                .doOnRequest(n -> System.out.println("Requesting items from API" ))
                .limitRate(10)
                .flatMap(user -> {
                    User user1 = new User(user.login());
                    return userRepository.save(user1);
                })
                .subscribe(
                        item -> System.out.println("Received item: {} " + item),
                        error -> System.err.println("Error: {} " + error),
                        () -> System.out.println("Processing items from API completed")
                );
    }

}
