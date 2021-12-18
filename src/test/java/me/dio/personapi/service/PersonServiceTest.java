package me.dio.personapi.service;

import me.dio.personapi.dto.request.PersonDTO;
import me.dio.personapi.entity.Person;
import me.dio.personapi.mapper.PersonMapper;
import me.dio.personapi.repositories.PersonRepository;
import me.dio.personapi.response.MessageResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static me.dio.personapi.utils.PersonUtils.createFakeDTO;
import static me.dio.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSuccessSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personMapper.toModel(personDTO)).thenReturn(expectedSavedPerson);
        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessResponse(expectedSavedPerson.getId());
        MessageResponseDTO successMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessResponse(Long id) {
        return MessageResponseDTO.builder()
                .message("Person successfully created with ID " + id)
                .build();
    }
}
