package com.ghost.caesboot.resources;

import com.ghost.caesboot.domain.Post;
import com.ghost.caesboot.domain.User;
import com.ghost.caesboot.dto.UserDTO;
import com.ghost.caesboot.resources.util.URL;
import com.ghost.caesboot.services.PostService;
import com.ghost.caesboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    //    @GetMapping ou
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findAll() {
        List<Post> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
         return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
            ) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = service.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }



//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
//        User obj = service.fromDTO(objDto);
//        obj = service.insert(obj);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Void> delete(@PathVariable String id) {
//        service.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
//        User obj = service.fromDTO(objDto);
//        obj.setId(id);
//        obj = service.update(obj);
//        return ResponseEntity.noContent().build();
//    }
//    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
//    public ResponseEntity<List<Post>> findUserPosts(@PathVariable String id) {
//        User obj = service.findById(id);
//        return ResponseEntity.ok().body(obj.getPosts());
//    }





}
