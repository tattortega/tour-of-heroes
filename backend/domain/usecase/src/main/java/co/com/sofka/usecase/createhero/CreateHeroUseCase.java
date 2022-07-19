package co.com.sofka.usecase.createhero;

import co.com.sofka.model.hero.Hero;
import co.com.sofka.model.hero.gateways.HeroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateHeroUseCase {

    private final HeroRepository repository;

    public Mono<Hero> createHero(Hero hero){
        return repository.save(hero);
    }
}
