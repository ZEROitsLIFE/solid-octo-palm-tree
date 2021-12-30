package net.proselyte.jwtappdemo.rest;

import net.proselyte.jwtappdemo.dto.CommentDto;
import net.proselyte.jwtappdemo.dto.UserDto;
import net.proselyte.jwtappdemo.model.Comments;
import net.proselyte.jwtappdemo.model.User;
import net.proselyte.jwtappdemo.service.UserService;
import net.proselyte.jwtappdemo.service.impl.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * REST controller user connected requestst.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@RestController
@RequestMapping(value = "/api/v1/users/")
public class UserRestControllerV1 {
    private final UserService userService;
    private final CommentsService commentsService;


    @Autowired
    public UserRestControllerV1(UserService userService, CommentsService commentsService) {
        this.userService = userService;
        this.commentsService = commentsService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id){
        User user = userService.findById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result = UserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping(value = "/comments/{username}")
    public ResponseEntity<CommentDto> getCommentByUsername(@PathVariable String username){
        Comments comments = commentsService.findByUsername(username);

        if(comments == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        CommentDto result = CommentDto.fromComments(comments);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/comments")
    public List<Comments> getComment(){
        List<Comments> comments = commentsService.getCommentsAll();
        List<CommentDto> dtoList = new ArrayList<>();
        for(int i = 0; i< comments.size(); i++) {
            CommentDto commentDto = CommentDto.fromComments(comments.get(i));
        dtoList.add(commentDto);
        }
        return comments;
    }


    }


