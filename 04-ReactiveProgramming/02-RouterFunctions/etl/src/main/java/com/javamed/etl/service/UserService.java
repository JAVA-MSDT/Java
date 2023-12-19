package com.javamed.etl.service;

import com.javamed.etl.modal.User;
import com.javamed.etl.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse> insertUser(ServerRequest request) {
        String login = request.pathVariable("login");

        return userRepository.existsByLogin(login)
                .flatMap(exists -> {
                    if (exists) {
                        return ServerResponse.status(HttpStatus.CONFLICT)
                                .body(BodyInserters.fromValue("User already exists"));
                    } else {
                        return userRepository.save(new User(login))
                                .flatMap(user -> ServerResponse.status(HttpStatus.CREATED)
                                        .body(BodyInserters.fromValue(user)));
                    }
                });
    }

    public Mono<ServerResponse> searchUsers(ServerRequest request) {
        String query = request.queryParam("q").orElse("");
        return userRepository.findByLoginContainingIgnoreCase(query)
                .collectList()
                .flatMap(users -> ServerResponse.ok().body(BodyInserters.fromValue(users)));
    }

    public Mono<ServerResponse> findAllUsers(ServerRequest request) {
        return userRepository.findAll()
                .collectList()
                .flatMap(users -> ServerResponse.ok().body(BodyInserters.fromValue(users)));
    }
}
