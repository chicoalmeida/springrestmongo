package br.com.chico.sample.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author Francisco Almeida on 15/06/2016.
 */
@Data
public class Person {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Address address;
}
