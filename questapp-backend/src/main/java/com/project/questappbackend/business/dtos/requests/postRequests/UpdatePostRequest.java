package com.project.questappbackend.business.dtos.requests.postRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UpdatePostRequest {
    private Long userId;
    private Long id;
    private String title;
    private String text;
}
