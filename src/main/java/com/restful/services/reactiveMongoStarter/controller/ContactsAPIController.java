package com.restful.services.reactiveMongoStarter.controller;

import com.restful.services.reactiveMongoStarter.model.Contacts;
import com.restful.services.reactiveMongoStarter.repositories.ContactsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/contacts")
public class ContactsAPIController {

    @Autowired
    private ContactsRepository contactsRepo;

    /* Sends All the data availabe in the collection. */
    @GetMapping("/get")
    public Flux<Contacts> index() {
        return contactsRepo.findAll();
    }

    /* Sends the data matching the email. */
    @GetMapping("/get/{email}")
    public Mono<Contacts> getContactByEmail(@PathVariable("email") String email) {
        return contactsRepo.findByEmail(email);
    }

    /* Add new contact */
    @PostMapping(path = "/add", consumes = "application/json")
    public Mono<Contacts> addNewContact(@RequestBody Contacts contact) {
        return contactsRepo.save(contact);
    }

    /* Update existing contact */
    @PostMapping(path = "/update/{id}", consumes = "application/json")
    public Mono<Contacts> updateContactById(@PathVariable("id") String id, @RequestBody Contacts contact) {
        return contactsRepo.findById(id)
                .flatMap(existingContact -> {
                    existingContact.setName(contact.getName());
                    existingContact.setEmail(contact.getEmail());
                    return contactsRepo.save(existingContact);
                });
    }

    /* Delete existing contact */
    @PostMapping(path = "/delete/{id}")
    public Mono<String> deleteContactById(@PathVariable("id") String id) {
        return contactsRepo.deleteById(id).thenReturn("Successfully deleted -> "+id);
    }
}
