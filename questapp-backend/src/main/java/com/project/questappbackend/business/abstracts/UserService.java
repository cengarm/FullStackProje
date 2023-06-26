package com.project.questappbackend.business.abstracts;

import com.project.questappbackend.business.dtos.requests.userRequests.CreateUserRequest;
import com.project.questappbackend.business.dtos.requests.userRequests.UpdateUserRequest;
import com.project.questappbackend.business.dtos.responses.GetByIdUserResponse;
import com.project.questappbackend.business.dtos.responses.UserListResponse;

import java.util.List;

public interface UserService {

    List<UserListResponse> getAllUsers();
    GetByIdUserResponse getByIdUser(Long userId);
    void add(CreateUserRequest createUserRequest);
    void update(UpdateUserRequest updateUserRequest);
    void delete(Long userId);

}
