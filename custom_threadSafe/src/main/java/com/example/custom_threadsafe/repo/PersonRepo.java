package com.example.custom_threadsafe.repo;

import com.example.custom_threadsafe.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface PersonRepo extends JpaRepository<Person , Long>,CustomRepo,CustomThreadSafe {
    @Query(value = "with alerts_table(sensor_primary_id, sensor_secondary_id,  sensor_protocol)\n" +
                    "as (values \n" +
                    "?1"+
                    ")\n" +
                    "select * from alerts_table;" , nativeQuery = true)
    List<Map<String , Object>> findDemo(String sqlSyntax);
}
