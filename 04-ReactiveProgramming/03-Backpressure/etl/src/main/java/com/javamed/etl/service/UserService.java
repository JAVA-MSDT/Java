package com.javamed.etl.service;

import com.javamed.etl.modal.User;
import com.javamed.etl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

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

    public Mono<ServerResponse> findAllUsersByBackpressure(ServerRequest request) {
        return userRepository.findAll()
                .doOnSubscribe(subscription -> {
                    log.info("Requesting 10 elements");
                    subscription.request(10);
                })
                .doOnNext(user -> log.info("onNext: {}", user))
                .limitRate(10)
                .collectList()
                .flatMap(users -> {
                    log.info("Requesting another 10 elements");
                    return ServerResponse.ok().bodyValue(users);
                });
    }

    // This is only a demonstration that the backpressure will return 10 at a time
    // it will not return users, but it will return list of integers because of the scan function
    // to see it work, just replace it with findAllUsersByBackpressure method in
    // .GET(findAllUsersByBackpressure, userService::findAllUsersByBackpressure)
    public Mono<ServerResponse> findAllUsersByBackpressureLog(ServerRequest request) {
        return userRepository.findAll()
                .doOnSubscribe(subscription -> {
                    log.info("Requesting 10 elements");
                    subscription.request(10);
                })
                .doOnNext(user -> log.info("onNext: {}", user))
                .scan(0, (count, user) -> count + 1)
                .doOnNext(count -> {
                    log.info("Total elements processed: {}", count);
                    if (count % 10 == 0) {
                        log.info("Requesting another 10 elements");
                    }
                })
                .limitRate(10)
                .collectList()
                .flatMap(users -> {
                    log.info("Requesting another 10 elements");
                    return ServerResponse.ok().bodyValue(users);
                });
    }

}
