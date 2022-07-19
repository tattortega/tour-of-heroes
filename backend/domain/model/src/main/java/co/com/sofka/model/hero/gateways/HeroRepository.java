package co.com.sofka.model.hero.gateways;

import co.com.sofka.model.hero.Hero;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HeroRepository {

    Mono<Hero> save(Hero hero);
    Flux<Hero> findAll();
    Mono<Hero> findById(String id);
    Flux<Hero> findByName(String name);
    Mono<Void> delete(String id);
    Mono<Hero> update(String id, Hero hero);
}