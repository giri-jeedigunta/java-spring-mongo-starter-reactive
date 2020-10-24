package com.restful.services.springReactiveRESTApp.repositories;

import com.restful.services.springReactiveRESTApp.model.Apis;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ApisRepository extends ReactiveMongoRepository<Apis, String> {
    Mono<Apis> findByEmail(String email);
}