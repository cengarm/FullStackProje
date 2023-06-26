package com.project.questappbackend.business.dtos.requests.userRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private Long id;
    private String userName;
    private String password;
}
