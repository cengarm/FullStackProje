package com.project.questappbackend.business.dtos.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.questappbackend.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByIdPostResponse {

    private Long userId;
    private Long id;
    private String title;
    private String text;
}
