package co.com.sofka.usecase.updatehero;

import co.com.sofka.model.hero.Hero;
import co.com.sofka.model.hero.gateways.HeroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateHeroUseCase {

    private final HeroRepository repository;

    public Mono<Hero> updateHero(String id, Hero hero){
        return repository.update(id, hero);
    }
}
