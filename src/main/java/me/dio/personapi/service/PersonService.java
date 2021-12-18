package me.dio.personapi.service;


import me.dio.personapi.dto.request.PersonDTO;
import me.dio.personapi.entity.Person;
import me.dio.personapi.mapper.PersonMapper;
import me.dio.personapi.repositories.PersonRepository;
import me.dio.personapi.response.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personrepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personrepository) {
        this.personrepository = personrepository;
    }


    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = personMapper.toModel(personDTO);

        Person savePerson = personrepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID" + savePerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personrepository.findAll();
        return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }
}
