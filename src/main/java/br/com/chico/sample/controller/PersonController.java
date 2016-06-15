package br.com.chico.sample.controller;

import br.com.chico.sample.model.Person;
import br.com.chico.sample.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author Francisco Almeida on 15/06/2016.
 */
@RestController
@Slf4j
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonRepository repository;

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPersonById(@PathVariable String id) {
        log.info("getPersonById with parameter $id");
        return new ResponseEntity<>(repository.findOne(id), OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getAllPersons() {
        log.info("getAllPersons()");
        return new ResponseEntity<>(repository.findAll(), OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Person> createPerson(@RequestBody Person newPerson) {
        log.info("createPerson with parameter $newPerson");
        newPerson.setId(null);
        return new ResponseEntity<>(repository.save(newPerson), CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Person> updatePerson(@PathVariable String id, @RequestBody Person updatedPerson) {
        log.info("updatePerson with parameter $id and $updatedPerson");
        updatedPerson.setId(id);
        return new ResponseEntity<>(repository.save(updatedPerson), OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> removePerson(@PathVariable String id) {
        log.info("removePerson with parameter $id");
        repository.delete(id);
        return new ResponseEntity<>(OK);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/search/byFirstName/{firstName}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPersonByFirstName(@PathVariable String firstName) {
        log.info("getPersonByFirstName with parameter $firstName");
        return new ResponseEntity<>(repository.findByFirstName(firstName), OK);
    }
}
