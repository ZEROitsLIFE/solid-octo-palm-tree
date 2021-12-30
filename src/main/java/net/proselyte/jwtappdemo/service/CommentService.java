package net.proselyte.jwtappdemo.service;

import net.proselyte.jwtappdemo.dto.CommentDto;
import net.proselyte.jwtappdemo.model.Comments;

import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto);

    CommentDto createComment(Comments comments);

    List<Comments> getCommentsAll();


    Comments findByUsername(String username);

    CommentDto updateComment(long commentId, CommentDto commentRequest);

    void deleteComment(Long commentId);


}
