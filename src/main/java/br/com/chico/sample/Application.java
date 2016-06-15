package br.com.chico.sample;

import br.com.chico.sample.model.Address;
import br.com.chico.sample.model.Person;
import br.com.chico.sample.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@Slf4j
public class Application {

    @Autowired
    private PersonRepository repository;

    public static void main(String[] args) {
        run(Application.class, args);
    }


    @PostConstruct
    void init() {
        repository.deleteAll();

        log.info("Setting up test data");
        repository.save(
                Arrays.asList(
                        new Person(null, "Arthur", "Dent", new Address("Earth")),
                        new Person(null, "Trillian", "McMillan", new Address("Earth")),
                        new Person(null, "Ford", "Prefect", new Address("Betelgeuse 5"))
                )
        );
    }
}
