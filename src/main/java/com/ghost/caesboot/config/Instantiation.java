package com.ghost.caesboot.config;

import com.ghost.caesboot.domain.Post;
import com.ghost.caesboot.domain.User;
import com.ghost.caesboot.repository.PostRepository;
import com.ghost.caesboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User bobEsponja = new User(null, "Bob Esponja", "bob@gmail.com");
        User bruceWayne = new User(null, "Bruce Wayne", "brcwyn@batemail.com");
        User tonyStark = new User(null, "Tony Stark", "ts@starkindustries.com");

        Post post1 = new Post(null, sdf.parse("01/01/2016"), "Estou pronto !", "Estoooooooou prontoooooo, estoooooou prontooooo", bruceWayne );
        Post post2 = new Post(null, sdf.parse("21/03/2018"), "anti vilão", "vamos derrotar todos os vilões deste universo", bruceWayne );
        Post post3 = new Post(null, sdf.parse("17/06/2019"), "união", "unieremos a liga da justiça com os vingadores", tonyStark );

        userRepository.saveAll(Arrays.asList(bobEsponja,bruceWayne,tonyStark));
        postRepository.saveAll(Arrays.asList(post1,post2, post3));
    }
}
