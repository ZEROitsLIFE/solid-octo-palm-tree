package net.proselyte.jwtappdemo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
@Data
public class Comments extends BaseEntity{

    @Column(name = "username")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "body")
    private String body;



    @Override
    public String toString() {
        return "Comments{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }



}
