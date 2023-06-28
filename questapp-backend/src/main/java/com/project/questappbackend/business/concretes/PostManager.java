package com.project.questappbackend.business.concretes;

import com.project.questappbackend.business.abstracts.PostService;
import com.project.questappbackend.business.core.utilities.mapping.ModelMapperService;
import com.project.questappbackend.business.dtos.requests.postRequests.CreatePostRequest;
import com.project.questappbackend.business.dtos.requests.postRequests.UpdatePostRequest;
import com.project.questappbackend.business.dtos.responses.GetByIdPostResponse;
import com.project.questappbackend.business.dtos.responses.PostListResponse;
import com.project.questappbackend.business.dtos.responses.UserAllPostResponse;
import com.project.questappbackend.dataAccess.PostRepository;
import com.project.questappbackend.dataAccess.UserRepository;
import com.project.questappbackend.entities.Post;
import com.project.questappbackend.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostManager implements PostService {

    private final PostRepository postRepository;
    private final ModelMapperService modelMapperService;
    private final UserRepository userRepository;

    @Override
    public List<PostListResponse> getAllPost() {
        List<Post> posts = this.postRepository.findAll();
        List<PostListResponse> responses = posts.stream().map(post -> this.modelMapperService.forResponse()
                .map(post, PostListResponse.class)).collect(Collectors.toList());
        return responses;
    }


    @Override
    public List<UserAllPostResponse> getUserAllPosts(Long userId)throws Exception {

        User userFromDb = userRepository
                .findById(userId).orElseThrow(()-> new Exception("Böyle bir user yok!"));

        List<Post> postList = postRepository
                .getAllByUser(userFromDb)
                .orElseThrow(()-> new Exception("Bu kullanıcıya ait hiç post yok!")); //Lambda -> Functional Interface

        List<UserAllPostResponse> responses =postList.stream().map(user -> this.modelMapperService.forResponse()
                .map(user, UserAllPostResponse.class)).collect(Collectors.toList());

        return responses;
    }


    @Override
    public GetByIdPostResponse getByIdPost(Long userId) {
        Post post = this.postRepository.getById(userId);
        GetByIdPostResponse response = this.modelMapperService.forResponse()
                .map(post,GetByIdPostResponse.class);
        return response;
    }


    @Override
    public void add(CreatePostRequest createPostRequest) {
        Post post = this.modelMapperService.forRequest().map(createPostRequest,Post.class);
        this.postRepository.save(post);
    }

    @Override
    public void update(UpdatePostRequest updatePostRequest) {
        Post post =this.modelMapperService.forRequest().map(updatePostRequest,Post.class);
        this.postRepository.save(post);
    }


    @Override
    public void delete(Long postId) {
        this.postRepository.deleteById(postId);
    }
}
