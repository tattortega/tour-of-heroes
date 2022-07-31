package co.com.sofka.api.hero.handler;

import co.com.sofka.model.hero.Hero;
import co.com.sofka.usecase.hero.createhero.CreateHeroUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreateHeroHandler {

    private final CreateHeroUseCase createHeroUseCase;

    public Mono<ServerResponse> createHero(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(Hero.class)
                .flatMap(this.createHeroUseCase::apply)
                .flatMap(hero -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(hero));
    }
}
