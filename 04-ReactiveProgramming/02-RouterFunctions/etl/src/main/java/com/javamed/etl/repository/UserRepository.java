package com.javamed.etl.repository;

import com.javamed.etl.modal.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {

    Mono<Boolean> existsByLogin(String username);
    Flux<User> findByLoginContainingIgnoreCase(String query);

}
