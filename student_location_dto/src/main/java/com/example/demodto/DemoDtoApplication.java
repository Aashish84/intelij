package com.example.demodto;

import com.example.demodto.model.Location;
import com.example.demodto.model.User;
import com.example.demodto.repository.LocationRepository;
import com.example.demodto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoDtoApplication {

//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private LocationRepository locationRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoDtoApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Location location = new Location();
//        location.setPlace("nepal");
//        location.setDescription("this is description");
//        location.setLatitude(31.1);
//        location.setLongitude(2323.2);
//        locationRepository.save(location);
//
//        User user = new User();
//        user.setFirstName("asis");
//        user.setLastName("thapa");
//        user.setEmail("asis@gmail.com");
//        user.setPassword("password");
//        user.setLocation(location);
//
//        userRepository.save(user);
//    }

}
