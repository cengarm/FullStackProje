package com.project.questappbackend.business.concretes;

import com.project.questappbackend.business.abstracts.UserService;
import com.project.questappbackend.business.core.utilities.mapping.ModelMapperService;
import com.project.questappbackend.business.dtos.requests.userRequests.CreateUserRequest;
import com.project.questappbackend.business.dtos.requests.userRequests.UpdateUserRequest;
import com.project.questappbackend.business.dtos.responses.GetByIdUserResponse;
import com.project.questappbackend.business.dtos.responses.UserListResponse;
import com.project.questappbackend.dataAccess.UserRepository;
import com.project.questappbackend.entities.User;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService{
   private UserRepository userRepository;
   private ModelMapperService modelMapperService;

    public List<UserListResponse> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserListResponse> responses = users.stream().map(user -> this.modelMapperService.forResponse()
                .map(user,UserListResponse.class)).collect(Collectors.toList());

        return responses;
    }

    @Override
    public GetByIdUserResponse getByIdUser(Long userId) {
        User user = this.userRepository.getById(userId);
        GetByIdUserResponse response = this.modelMapperService.forResponse().map(user,GetByIdUserResponse.class);
        return response;
    }

    @Override
    public void add(CreateUserRequest createUserRequest) {
        User user = this.modelMapperService.forRequest().map(createUserRequest,User.class);
        user = this.userRepository.save(user);

    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        User user = this.modelMapperService.forRequest().map(updateUserRequest, User.class);
        user = this.userRepository.save(user);
    }

    @Override
    public void delete(Long userId) {
        this.userRepository.deleteById(userId);
    }

}
