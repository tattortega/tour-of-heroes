package co.com.sofka.usecase.getnamehero;

import co.com.sofka.model.hero.Hero;
import co.com.sofka.model.hero.gateways.HeroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetNameHeroUseCase {

    private final HeroRepository repository;

    public Flux<Hero> getNameHero(String name){
        return repository.findByName(name);
    }
}
