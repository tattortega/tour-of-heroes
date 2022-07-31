package co.com.sofka.api.hero.handler;

import co.com.sofka.model.hero.Hero;
import co.com.sofka.usecase.hero.createhero.CreateHeroUseCase;
import co.com.sofka.usecase.hero.deletehero.DeleteHeroUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DeleteHeroHandler {

    private final DeleteHeroUseCase deleteHeroUseCase;

    public Mono<ServerResponse> deleteHero(ServerRequest serverRequest) {
        return Mono.just(serverRequest
                        .pathVariable("id"))
                .flatMap(this.deleteHeroUseCase::apply)
                .flatMap(hero -> ServerResponse
                        .status(HttpStatus.NO_CONTENT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(hero));
    }
}
