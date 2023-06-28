package com.project.questappbackend.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByIdCommentResponse {

    private Long id;
    private String post;
    private String text;
}
