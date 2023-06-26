package com.project.questappbackend.dataAccess;

import com.project.questappbackend.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepository extends JpaRepository <Post,Long> {

}

