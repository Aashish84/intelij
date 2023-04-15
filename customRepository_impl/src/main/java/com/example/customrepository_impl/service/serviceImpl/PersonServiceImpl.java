package com.example.customrepository_impl.service.serviceImpl;

import com.example.customrepository_impl.entity.Person;
import com.example.customrepository_impl.repository.PersonRepo;
import com.example.customrepository_impl.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepo personRepo;
    @Override
    public List<Person> getAll() {
        return personRepo.findAll();
    }

    public List<Map<String,Object>> allPerson(){
        personRepo.doSomething();
        return personRepo.allPerson();
    }

    @Override
    public Person save(Person person) {
        return personRepo.save(person);
    }
}
