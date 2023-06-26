package com.project.questappbackend.business.abstracts;

import com.project.questappbackend.business.dtos.requests.postRequests.CreatePostRequest;
import com.project.questappbackend.business.dtos.requests.postRequests.UpdatePostRequest;
import com.project.questappbackend.business.dtos.requests.userRequests.CreateUserRequest;
import com.project.questappbackend.business.dtos.requests.userRequests.UpdateUserRequest;
import com.project.questappbackend.business.dtos.responses.*;
import com.project.questappbackend.entities.Post;

import java.util.List;

public interface PostService {
    List<PostListResponse> getAllPost();
    GetByIdPostResponse getByIdPost(Long userId);
    void add(CreatePostRequest createPostRequest);
    void update(UpdatePostRequest updatePostRequest);
    void delete(Long postId);

}

