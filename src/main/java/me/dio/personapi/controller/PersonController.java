package me.dio.personapi.controller;


import me.dio.personapi.entity.Person;
import me.dio.personapi.repositories.PersonRepository;
import me.dio.personapi.response.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personrepository;

    @Autowired
    public PersonController(PersonRepository personrepository) {
        this.personrepository = personrepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        Person savePerson = personrepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID" + savePerson.getId())
                .build();
    }

}
