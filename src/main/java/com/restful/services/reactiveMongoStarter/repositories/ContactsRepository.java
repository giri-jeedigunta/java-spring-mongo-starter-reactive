package com.restful.services.reactiveMongoStarter.repositories;

import com.restful.services.reactiveMongoStarter.model.Contacts;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ContactsRepository extends ReactiveMongoRepository<Contacts, String> {
}