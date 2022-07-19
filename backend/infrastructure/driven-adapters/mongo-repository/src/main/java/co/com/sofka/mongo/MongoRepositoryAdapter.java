package co.com.sofka.mongo;

import co.com.sofka.model.hero.Hero;
import co.com.sofka.model.hero.gateways.HeroRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Hero, HeroDocument, String, MongoDBRepository>
 implements HeroRepository
{

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Hero.class));
    }

    @Override
    public Flux<Hero> findByName(String name) {
        return  repository.findByName(name);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono<Hero> update(String id, Hero hero) {
        hero.setId(id);
        return repository
                .save(new HeroDocument(hero.getId(), hero.getName()))
                .flatMap(element -> Mono.just(hero));    }
}
