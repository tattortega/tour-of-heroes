package co.com.sofka.api.hero.handler;

import co.com.sofka.model.hero.Hero;
import co.com.sofka.usecase.hero.createhero.CreateHeroUseCase;
import co.com.sofka.usecase.hero.getallhero.GetAllHeroUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class GetAllHeroesHandler {

    private final GetAllHeroUseCase getAllHeroUseCase;

    public Mono<ServerResponse> getAllHeroes(ServerRequest serverRequest) {
        return ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllHeroUseCase.get(), Hero.class));
    }
}
