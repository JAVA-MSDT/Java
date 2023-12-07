package com.javamed.etl;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    // @Query("SELECT * FROM USERS WHERE LOGIN = $1")
    Mono<User> findByLogin(String login);
}
