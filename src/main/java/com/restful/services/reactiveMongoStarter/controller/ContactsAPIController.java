package com.restful.services.reactiveMongoStarter.controller;

import com.restful.services.reactiveMongoStarter.model.Contacts;
import com.restful.services.reactiveMongoStarter.repositories.ContactsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@Slf4j
@RequestMapping("/contacts")
public class ContactsAPIController {

    @Autowired
    private ContactsRepository contactsRepo;

    @GetMapping
    public String greeting() {
        return "Server up and running !!!";
    }

    @GetMapping("/get")
    public Flux<Contacts> index() {
        return contactsRepo.findAll();
    }
}
