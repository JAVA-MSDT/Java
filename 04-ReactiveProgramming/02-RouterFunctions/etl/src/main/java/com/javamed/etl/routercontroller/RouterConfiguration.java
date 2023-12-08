package com.javamed.etl.routercontroller;

import com.javamed.etl.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
@Configuration
public class RouterConfiguration {

    @Bean
    public RouterFunction<ServerResponse> userRoutes(UserService userService) {
        return RouterFunctions.route()
                .GET("/api/v1/users/all", userService::findAllUsers)
                .POST("/api/v1/users/{login}", userService::insertUser)
                .GET("/api/v1/users", userService::searchUsers)
                .build();
    }
}
