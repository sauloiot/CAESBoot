package com.ghost.caesboot.repository;

import com.ghost.caesboot.domain.Post;
import com.ghost.caesboot.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
