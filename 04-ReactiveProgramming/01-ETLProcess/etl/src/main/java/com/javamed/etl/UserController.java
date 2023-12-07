package com.javamed.etl;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public Flux<User> findAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public Mono<User> saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

}
