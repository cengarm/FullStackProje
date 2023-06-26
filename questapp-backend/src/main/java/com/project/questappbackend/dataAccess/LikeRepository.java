package com.project.questappbackend.dataAccess;

import com.project.questappbackend.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository <Like,Long> {
}
