package com.project.questappbackend.webApi.controllers;

import com.project.questappbackend.business.abstracts.PostService;
import com.project.questappbackend.business.abstracts.UserService;
import com.project.questappbackend.business.dtos.requests.postRequests.CreatePostRequest;
import com.project.questappbackend.business.dtos.requests.postRequests.UpdatePostRequest;
import com.project.questappbackend.business.dtos.responses.GetByIdPostResponse;
import com.project.questappbackend.business.dtos.responses.PostListResponse;
import com.project.questappbackend.business.dtos.responses.UserAllPostResponse;
import com.project.questappbackend.dataAccess.PostRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {

    private PostService postService;
    private UserService userService;
    private PostRepository postRepository;


    @GetMapping
    public List<PostListResponse> getAllPosts() {
        return postService.getAllPost();
    }

    @GetMapping("/UserAllPost/{userId}")
    public  List<UserAllPostResponse> getAllUserPost(@PathVariable Long userId) {
        try {
            return postService.getUserAllPosts(userId);
        } catch (Exception exception){
            return null;
        }

    }


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreatePostRequest createPostRequest) {
        this.postService.add(createPostRequest);
    }

    @GetMapping("/{postId}")
    public GetByIdPostResponse getById(@PathVariable Long postId){
        return this.postService.getByIdPost(postId);
    }


    @PutMapping("/{postId}")
    public void update(@RequestBody @Valid UpdatePostRequest updatePostRequest){
        this.postService.update(updatePostRequest);
    }

    @DeleteMapping("/{postId}")
    public void delete(@PathVariable Long postId){
        this.postService.delete(postId);
    }

}
