package com.ghost.caesboot.config;

import com.ghost.caesboot.domain.User;
import com.ghost.caesboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        User bobEsponja = new User(null, "Bob Esponja", "bob@gmail.com");
        User bruceWayne = new User(null, "Bruce Wayne", "brcwyn@batemail.com");
        User tonyStark = new User(null, "Tony Stark", "ts@starkindustries.com");

        userRepository.saveAll(Arrays.asList(bobEsponja,bruceWayne,tonyStark));
    }
}
