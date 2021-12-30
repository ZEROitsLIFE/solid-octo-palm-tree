package net.proselyte.jwtappdemo.rest;

import net.proselyte.jwtappdemo.dto.AdminUserDto;
import net.proselyte.jwtappdemo.dto.CommentDto;
import net.proselyte.jwtappdemo.model.Comments;
import net.proselyte.jwtappdemo.model.User;
import net.proselyte.jwtappdemo.service.UserService;
import net.proselyte.jwtappdemo.service.impl.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * REST controller for ROLE_ADMIN requests.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@RestController
@RequestMapping(value = "/api/v1/admin/")
public class AdminRestControllerV1 {

    private final UserService userService;

    @Autowired
    private CommentsService commentsService;

    @Autowired
    public AdminRestControllerV1(UserService userService) {
        this.userService = userService;

    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserDto result = AdminUserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/users")
    public List<AdminUserDto> getUserALll(){
        List<User> user = userService.getAll();
        List<AdminUserDto> dtoList = new ArrayList<>();
        for(int i = 0; i< user.size(); i++) {
            AdminUserDto adminUserDto = AdminUserDto.fromUser(user.get(i));
            dtoList.add(adminUserDto);
        }
        return dtoList;
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



    @DeleteMapping("/api/v1/admin/comments/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        commentsService.deleteComment(id);
    }
}
