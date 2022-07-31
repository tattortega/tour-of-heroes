package co.com.sofka.api;

import co.com.sofka.api.hero.handler.Handler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(Handler handler) {
    return route(GET("/api/hero"), handler::getAllHeroUseCase)
            .and(route(GET("/api/hero/{id}"), handler::getHeroUseCase))
            .and(route(GET("/api/hero/{name}"), handler::getNameHeroUseCase))
            .and(route(POST("/api/hero/create"), handler::createHeroUseCase))
            .and(route(PUT("/api/hero/{id}"), handler::updateHeroUseCase))
            .and(route(DELETE("/api/hero/{id}"), handler::deleteHeroUseCase));

    }
}
