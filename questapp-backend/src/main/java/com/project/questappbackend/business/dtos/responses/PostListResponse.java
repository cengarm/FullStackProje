package com.project.questappbackend.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostListResponse {
    private Long id;
    private String userName;
    private String title;
    private String text;

}
