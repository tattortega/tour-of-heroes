package co.com.sofka.api.hero.route;

import co.com.sofka.api.hero.handler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerCreateHeroFunction(CreateHeroHandler handler) {
        return route(POST("/api/hero"), handler::createHero);
    }

    @Bean
    public RouterFunction<ServerResponse> routerFindAllHeroesFunction(GetAllHeroesHandler handler) {
        return route(GET("/api/hero"), handler::getAllHeroes);
    }

    @Bean
    public RouterFunction<ServerResponse> routerGetHeroFunction(GetHeroHandler handler) {
        return route(GET("/api/hero/{id}"), handler::getHero);
    }

    @Bean
    public RouterFunction<ServerResponse> routerUpdateHeroFunction(UpdateHeroHandler handler) {
        return route(PUT("/api/hero/{id}"), handler::updateHero);
    }

    @Bean
    public RouterFunction<ServerResponse> routerDeleteHeroFunction(DeleteHeroHandler handler) {
        return route(DELETE("/api/hero/{id}"), handler::deleteHero);
    }
}

