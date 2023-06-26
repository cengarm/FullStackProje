package com.project.questappbackend.webApi.controllers;

import com.project.questappbackend.business.abstracts.UserService;
import com.project.questappbackend.business.dtos.requests.userRequests.CreateUserRequest;
import com.project.questappbackend.business.dtos.requests.userRequests.UpdateUserRequest;
import com.project.questappbackend.business.dtos.responses.GetByIdUserResponse;
import com.project.questappbackend.business.dtos.responses.UserListResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;


    @GetMapping
    public List<UserListResponse> getAllUsers(){
       return userService.getAllUsers();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateUserRequest createUserRequest) {
      this.userService.add(createUserRequest);
    }

    @GetMapping ("/{userId}")
    public GetByIdUserResponse getById (@PathVariable Long userId) {
        return userService.getByIdUser(userId);
    }

    @PutMapping ("/{userId}")
    public void update(@RequestBody() UpdateUserRequest updateUserRequest){
        this.userService.update(updateUserRequest);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId){
        this.userService.delete(userId);
    }


}
