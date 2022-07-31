package co.com.sofka.api.hero.handler;

import co.com.sofka.model.hero.Hero;
import co.com.sofka.usecase.hero.createhero.CreateHeroUseCase;
import co.com.sofka.usecase.hero.gethero.GetHeroUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class GetHeroHandler {

    private final GetHeroUseCase getHeroUseCase;

    public Mono<ServerResponse> getHero(ServerRequest serverRequest) {
        return Mono.just(serverRequest
                        .pathVariable("id"))
                .flatMap(this.getHeroUseCase::apply)
                .flatMap(hero -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(hero));
    }
}
