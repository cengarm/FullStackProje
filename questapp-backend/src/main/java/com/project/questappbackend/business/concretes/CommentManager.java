package com.project.questappbackend.business.concretes;

import com.project.questappbackend.business.abstracts.CommentService;
import com.project.questappbackend.business.core.utilities.mapping.ModelMapperService;
import com.project.questappbackend.business.dtos.requests.commentRequest.CreateCommentRequest;
import com.project.questappbackend.business.dtos.requests.commentRequest.UpdateCommentRequest;
import com.project.questappbackend.business.dtos.responses.CommentListResponse;
import com.project.questappbackend.business.dtos.responses.GetByIdCommentResponse;
import com.project.questappbackend.business.dtos.responses.GetByIdPostResponse;
import com.project.questappbackend.dataAccess.CommentRepository;
import com.project.questappbackend.entities.Comment;

import java.util.List;
import java.util.stream.Collectors;

public class CommentManager implements CommentService {
    private CommentRepository commentRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<CommentListResponse> getAllComment() {
        List<Comment> comments = this.commentRepository.findAll();
        List<CommentListResponse> responses = comments.stream().map(comment -> this.modelMapperService.forResponse()
                .map(comment, CommentListResponse.class)).collect(Collectors.toList());
        return responses;
    }

    @Override
    public GetByIdCommentResponse getByIdComment(Long commentId) {
        Comment comment = this.commentRepository.getById(commentId);
        GetByIdCommentResponse response= this.modelMapperService.forResponse()
                .map(comment, GetByIdCommentResponse.class);
        return response;
    }

    @Override
    public void add(CreateCommentRequest createCommentRequest) {

        Comment comment = this.modelMapperService.forRequest()
                .map(createCommentRequest,Comment.class);
        this.commentRepository.save(comment);

    }

    @Override
    public void update(UpdateCommentRequest updateCommentRequest) {
        Comment comment = this.modelMapperService.forRequest()
                .map(updateCommentRequest,Comment.class);
        this.commentRepository.save(comment);
    }

    @Override
    public void delete(Long commentId) {
    this.commentRepository.deleteById(commentId);
    }
}
