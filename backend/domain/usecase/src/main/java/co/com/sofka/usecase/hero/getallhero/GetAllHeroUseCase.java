package co.com.sofka.usecase.getallhero;

import co.com.sofka.model.hero.Hero;
import co.com.sofka.model.hero.gateways.HeroRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetAllHeroUseCase {

    private final HeroRepository repository;

    public Flux<Hero> getAlleHero(){
        return repository.findAll();
    }
}
