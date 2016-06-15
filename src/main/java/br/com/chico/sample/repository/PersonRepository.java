package br.com.chico.sample.repository;

import br.com.chico.sample.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Francisco Almeida on 15/06/2016.
 */
public interface PersonRepository extends MongoRepository<Person, String> {

    Person findByFirstName(String firstName);

    List<Person> findByLastName(String lastName);

    List<Person> findByAddressPlanet(String planet);

}
