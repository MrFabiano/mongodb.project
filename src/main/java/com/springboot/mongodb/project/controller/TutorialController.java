package com.springboot.mongodb.project.controller;

import com.springboot.mongodb.project.model.Tutorial;
import com.springboot.mongodb.project.repository.TutorialRepository;
import com.springboot.mongodb.project.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class TutorialController {
    @Autowired
    private final TutorialRepository tutorialRepository;

    @Autowired
    private final TutorialService tutorialService;

    public TutorialController(TutorialRepository tutorialRepository, TutorialService tutorialService) {
        this.tutorialRepository = tutorialRepository;
        this.tutorialService = tutorialService;
    }

    @PostMapping(value = "/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        try {
            Tutorial tutorial1 = tutorialRepository.save(new Tutorial(tutorial.getDescription(), tutorial.getTitle(), false));
            return new ResponseEntity<>(tutorial1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title,
                                                          @RequestParam(required = false) String description,
                                                          @RequestParam(required = false) boolean publiched) {
        try {
            List<Tutorial> tutorials = new ArrayList<Tutorial>();
            if (title == null)
                tutorialRepository.findAll().forEach(tutorials::add);
            else
                tutorialRepository.findByTitleContaining(title, description, publiched).forEach(tutorials::add);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/tutorials/")
    public  ResponseEntity<List<Tutorial>> readTutorials(Tutorial tutorial, @RequestParam(required = false) String title,
                                                                            @RequestParam(required = false) String description, 
                                                                            @RequestParam(required = false) boolean publiched) {

        return Optional.of(tutorialService.buscarTutotorial(tutorial, title, description, publiched))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
}



