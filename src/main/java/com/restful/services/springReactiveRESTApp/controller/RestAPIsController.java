package com.restful.services.springReactiveRESTApp.controller;

import com.restful.services.springReactiveRESTApp.model.Apis;
import com.restful.services.springReactiveRESTApp.repositories.ApisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/api")
public class RestAPIsController {

    @Autowired
    private ApisRepository apiRepo;

    /* Sends All the data availabe in the collection. */
    @GetMapping("/get")
    public Flux<Apis> index() {
        return apiRepo.findAll();
    }

    /* Sends the data matching the email. */
    @GetMapping("/get/{email}")
    public Mono<Apis> getContactByEmail(@PathVariable("email") String email) {
        return apiRepo.findByEmail(email);
    }

    /* Add new contact */
    @PostMapping(path = "/add", consumes = "application/json")
    public Mono<Apis> addNewContact(@RequestBody Apis contact) {
        return apiRepo.save(contact);
    }

    /* Update existing contact */
    @PostMapping(path = "/update/{id}", consumes = "application/json")
    public Mono<Apis> updateContactById(@PathVariable("id") String id, @RequestBody Apis contact) {
        return apiRepo.findById(id)
                .flatMap(existingContact -> {
                    existingContact.setName(contact.getName());
                    existingContact.setEmail(contact.getEmail());
                    return apiRepo.save(existingContact);
                });
    }

    /* Delete existing contact */
    @PostMapping(path = "/delete/{id}")
    public Mono<String> deleteContactById(@PathVariable("id") String id) {
        return apiRepo.deleteById(id).thenReturn("Successfully deleted -> "+id);
    }
}
