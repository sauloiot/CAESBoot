package com.ghost.caesboot.services;

import com.ghost.caesboot.domain.Post;
import com.ghost.caesboot.domain.User;
import com.ghost.caesboot.dto.UserDTO;
import com.ghost.caesboot.repository.PostRepository;
import com.ghost.caesboot.repository.UserRepository;
import com.ghost.caesboot.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;


    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found."));
    }

    public List<Post> findAll(){
        return repo.findAll();
    }

    //principal
//    public List<Post> findByTitle(String text){
//        return repo.findByTitleContainingIgnoreCase(text);
//    }

    //alternativo
    public List<Post> findByTitle(String text){
        return repo.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }

//    public User insert(User obj){
//        return repo.insert(obj);
//    }
//
//    public void delete(String id){
//        findById(id);
//        repo.deleteById(id);
//    }
//
//    public User update(User obj){
//        User newObj = findById(obj.getId());
//        updateData(newObj, obj);
//        return repo.save(newObj);
//    }
//
//    private void updateData(User newObj, User obj) {
//        newObj.setName(obj.getName());
//        newObj.setEmail(obj.getEmail());
//    }
//
//    public User fromDTO(UserDTO objDto){
//        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
//    }



}
