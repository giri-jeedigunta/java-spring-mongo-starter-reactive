package com.restful.services.SpringReactiveRESTApiServer.repositories;

import com.restful.services.SpringReactiveRESTApiServer.model.Apis;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ApisRepository extends ReactiveMongoRepository<Apis, String> {
    Mono<Apis> findByEmail(String email);
}