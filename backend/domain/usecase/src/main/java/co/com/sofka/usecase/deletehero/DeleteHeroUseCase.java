package co.com.sofka.usecase.deletehero;

import co.com.sofka.model.hero.Hero;
import co.com.sofka.model.hero.gateways.HeroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteHeroUseCase {

    private final HeroRepository repository;

    public Mono<Void> deleteHero(String id){
        return repository.delete(id);
    }
}
