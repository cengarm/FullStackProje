package com.project.questappbackend.webApi.controllers;

import com.project.questappbackend.business.abstracts.CommentService;
import com.project.questappbackend.business.dtos.requests.commentRequest.CreateCommentRequest;
import com.project.questappbackend.business.dtos.requests.commentRequest.UpdateCommentRequest;
import com.project.questappbackend.business.dtos.responses.CommentListResponse;
import com.project.questappbackend.business.dtos.responses.GetByIdCommentResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {

   private CommentService commentService;

   @GetMapping
   public List<CommentListResponse> getAllComments() {
      return commentService.getAllComment();
   }

   @PostMapping
   public void add(@RequestBody CreateCommentRequest commentRequest){
      this.commentService.add(commentRequest);
   }

   @GetMapping("/{commentId}")
   public GetByIdCommentResponse getById (@PathVariable Long commentId){
      return this.commentService.getByIdComment(commentId);
   }


   @PostMapping("/{commentId}")
   public void update(@RequestBody UpdateCommentRequest commentRequest){
      this.commentService.update(commentRequest);
   }

   @DeleteMapping("/{commentId}")
   public void delete(@PathVariable Long commentId){
      this.commentService.delete(commentId);
   }

}
