package net.proselyte.jwtappdemo.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.proselyte.jwtappdemo.dto.CommentDto;
import net.proselyte.jwtappdemo.model.Comments;
import net.proselyte.jwtappdemo.repository.CommentsRepository;
import net.proselyte.jwtappdemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentsService implements CommentService {

    private final CommentsRepository commentsRepository;

    @Autowired
    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        return null;
    }

    @Override
    public CommentDto createComment(Comments comments) {
        return null;
    }

    @Override
    public List<Comments> getCommentsAll() {
        List<Comments> result = commentsRepository.findAll();
        log.info("IN getAll - {} comments found", result.size());
        return result;
    }



    @Override
    public Comments findByUsername(String username) {
        Comments result = commentsRepository.findByName(username);
        log.info("IN findByUsername - user: {} found by username: {}", result, username);
        return result;
    }

    @Override
    public CommentDto updateComment(long commentId, CommentDto commentRequest) {
        return null;
    }

    @Override
    public void deleteComment(Long id) {
        commentsRepository.deleteById(id);
        log.info("IN delete - comment with id: {} successfully deleted");
    }
}
