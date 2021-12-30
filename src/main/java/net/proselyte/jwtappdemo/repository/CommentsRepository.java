package net.proselyte.jwtappdemo.repository;

import net.proselyte.jwtappdemo.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments,Long> {

    @Query("SELECT a FROM Comments a WHERE a.name = :name")
   Comments findByName(String name);


}


