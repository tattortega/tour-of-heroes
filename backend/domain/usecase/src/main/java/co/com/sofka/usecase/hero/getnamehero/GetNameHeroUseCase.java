package co.com.sofka.usecase.hero.getnamehero;

import co.com.sofka.model.hero.Hero;
import co.com.sofka.model.hero.gateways.HeroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class GetNameHeroUseCase implements Function<String, Flux<Hero>> {

    private final HeroRepository repository;

    @Override
    public Flux<Hero> apply(String name) {
        return repository.findByName(name);
    }
}
