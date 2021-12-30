package net.proselyte.jwtappdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import net.proselyte.jwtappdemo.model.Comments;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentAdminDto {

    private long id;
    private String name;
    private String email;
    private String body;



    public Comments toComments(){
        Comments comments = new Comments();
        comments.setId(id);
        comments.setName(name);
        comments.setBody(email);
        comments.setBody(body);


        return comments;
    }

    public static CommentDto fromComments(Comments comments) {
        CommentDto comments1 = new CommentDto();
        comments1.setId(comments.getId());
        comments1.setName(comments.getName());
        comments1.setEmail(comments.getEmail());
        comments1.setBody(comments.getBody());

        return comments1;
    }
}
