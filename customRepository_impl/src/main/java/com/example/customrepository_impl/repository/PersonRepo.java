package com.example.customrepository_impl.repository;

import com.example.customrepository_impl.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface PersonRepo extends JpaRepository<Person , Long>,CustomPersonRepo {
    @Query(value = "select  * from person" , nativeQuery = true)
    List<Map<String , Object>> allPerson();
}
