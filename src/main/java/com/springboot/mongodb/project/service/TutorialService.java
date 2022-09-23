package com.springboot.mongodb.project.service;

import com.springboot.mongodb.project.model.Tutorial;
import com.springboot.mongodb.project.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;

    public Tutorial readTutorialTitle(String title) {
        Optional<Tutorial> tutorial = tutorialRepository.findById(title);
        if (tutorial.isPresent()) {
            return tutorial.get();
        }
        throw new RuntimeException("Cant find any book under given ID");
    }

    public List<Tutorial> readTutorials() {
        return tutorialRepository.findAll();
    }
}
