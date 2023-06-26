package com.project.questappbackend.dataAccess;

import com.project.questappbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Long> {
}
