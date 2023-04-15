package com.example.customrepository_impl.service;

import com.example.customrepository_impl.entity.Person;

import java.util.List;
import java.util.Map;

public interface PersonService {
    List<Person> getAll();
    Person save(Person person);
    List<Map<String , Object>> allPerson();
}
