package co.com.sofka.usecase.hero.deletehero;

import co.com.sofka.model.hero.Hero;
import co.com.sofka.model.hero.gateways.HeroRepository;
import co.com.sofka.usecase.exception.HeroNotFoundException;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;


@RequiredArgsConstructor
public class DeleteHeroUseCase implements Function<String, Mono<Void>> {

    private static final String HERO_CON_EL_ID_NO_EXISTE = "Hero con el id %s no existe";

    private final HeroRepository repository;

    @Override
    public Mono<Void> apply(String id){
        return repository.findById(id)
                .switchIfEmpty(
                        Mono.error(new HeroNotFoundException(String.format(HERO_CON_EL_ID_NO_EXISTE, id)))
                )
                .map(Hero::getId)
                .flatMap(repository::delete);
    }
}
