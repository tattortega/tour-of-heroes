package co.com.sofka.usecase.createhero;

import co.com.sofka.model.hero.Hero;
import co.com.sofka.model.hero.gateways.HeroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class CreateHeroUseCase implements Function<Hero, Mono<Hero>> {

    private final HeroRepository repository;

    @Override
    public Mono<Hero> apply(Hero hero){
        return repository.save(hero);
    }
}
