package com.springboot.mongodb.project.repository;

import com.springboot.mongodb.project.model.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TutorialRepository extends MongoRepository<Tutorial, String> {
    List<Tutorial> findByTitleContaining(String title, String description, boolean publiched);
//    List<Tutorial> findByPublished(boolean published);

}
