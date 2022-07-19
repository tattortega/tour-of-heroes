package co.com.sofka.mongo;

import co.com.sofka.model.hero.Hero;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Flux;

public interface MongoDBRepository extends ReactiveMongoRepository<HeroDocument, String>, ReactiveQueryByExampleExecutor<HeroDocument> {

    Flux<Hero> findByName(String name);


}
