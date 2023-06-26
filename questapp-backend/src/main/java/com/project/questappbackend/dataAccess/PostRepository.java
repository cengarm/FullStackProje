package com.project.questappbackend.dataAccess;

import com.project.questappbackend.entities.Post;
import com.project.questappbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface PostRepository extends JpaRepository <Post,Long> {

    public Optional<List<Post>> getAllByUser(User user);

}

