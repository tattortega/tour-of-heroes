package co.com.sofka.usecase.hero.updatehero;

import co.com.sofka.model.hero.Hero;
import co.com.sofka.model.hero.gateways.HeroRepository;
import co.com.sofka.usecase.exception.HeroNotFoundException;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@RequiredArgsConstructor
public class    UpdateHeroUseCase implements BiFunction<Hero, String, Mono<Hero>> {

    private final HeroRepository repository;

    @Override
    public Mono<Hero> apply(Hero hero, String id){
        return this.repository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("No se encontro")))
                .map(hero1 -> hero1.toBuilder()
                        .name(hero1.getName())
                        .build())
                .flatMap(this.repository::save);
    }
}
