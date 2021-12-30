package net.proselyte.jwtappdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import net.proselyte.jwtappdemo.model.Comments;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentDto {

    private long id;
    private String name;
    private String email;
    private String body;



    public  Comments toComments(){
        Comments comments = new Comments();
        comments.setId(id);
        comments.setName(name);
        comments.setBody(body);


        return comments;
    }

    public static CommentDto fromComments(Comments comments) {
        CommentDto comments1 = new CommentDto();
        comments1.setId(comments.getId());
        comments1.setName(comments.getName());
        comments1.setBody(comments.getBody());

        return comments1;
    }
}
