package co.com.sofka.usecase.hero.getallhero;

import co.com.sofka.model.hero.Hero;
import co.com.sofka.model.hero.gateways.HeroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

@RequiredArgsConstructor
public class GetAllHeroUseCase implements Supplier<Flux<Hero>> {

    private final HeroRepository repository;

    @Override
    public Flux<Hero> get(){
        return repository.findAll();
    }
}
