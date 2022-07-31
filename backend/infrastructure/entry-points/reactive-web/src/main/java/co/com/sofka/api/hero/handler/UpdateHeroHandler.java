package co.com.sofka.api.hero.handler;

import co.com.sofka.model.hero.Hero;
import co.com.sofka.usecase.hero.createhero.CreateHeroUseCase;
import co.com.sofka.usecase.hero.updatehero.UpdateHeroUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UpdateHeroHandler {

    private final UpdateHeroUseCase updateHeroUseCase;

    public Mono<ServerResponse> updateHero(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(Hero.class)
                .zipWith(Mono.just(serverRequest.pathVariable("id")))
                .flatMap(objects ->
                        this.updateHeroUseCase.apply(objects.getT1(), objects.getT2()))
                .flatMap(hero -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(hero));
    }
}
