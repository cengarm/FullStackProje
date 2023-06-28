package com.project.questappbackend.business.abstracts;

import com.project.questappbackend.business.dtos.requests.commentRequest.CreateCommentRequest;
import com.project.questappbackend.business.dtos.requests.commentRequest.UpdateCommentRequest;
import com.project.questappbackend.business.dtos.responses.CommentListResponse;
import com.project.questappbackend.business.dtos.responses.GetByIdCommentResponse;


import java.util.List;

public interface CommentService {
    List<CommentListResponse> getAllComment();
    GetByIdCommentResponse getByIdComment(Long commentId);
    void add(CreateCommentRequest createCommentRequest);
    void update(UpdateCommentRequest updateCommentRequest);
    void delete(Long commentId);
}
