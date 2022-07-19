package co.com.sofka.usecase.gethero;

import co.com.sofka.model.hero.Hero;
import co.com.sofka.model.hero.gateways.HeroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetHeroUseCase {

    private final HeroRepository repository;

    public Mono<Hero> getHero(String id){
        return repository.findById(id);
    }
}
