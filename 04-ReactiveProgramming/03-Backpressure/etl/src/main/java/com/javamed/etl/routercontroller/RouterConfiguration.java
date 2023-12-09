package com.javamed.etl.routercontroller;

import com.javamed.etl.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfiguration {

    @Value("${users.all}")
    private String findAllUsers;

    @Value("${users.backpressure}")
    private String findAllUsersByBackpressure;
    @Value("${users.save.by.login}")
    private String saveUserByLogin;
    @Value("${users.query.by.query.param}")
    private String queryUserByQueryParam;

    @Bean
    public RouterFunction<ServerResponse> userRoutes(UserService userService) {
        return RouterFunctions.route()
                .GET(findAllUsers, userService::findAllUsers)
                .GET(findAllUsersByBackpressure, userService::findAllUsersByBackpressure)
                .POST(saveUserByLogin, userService::insertUser)
                .GET(queryUserByQueryParam, userService::searchUsers)
                .build();
    }
}
