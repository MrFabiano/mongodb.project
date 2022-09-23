package com.springboot.mongodb.project.controller;

import com.springboot.mongodb.project.model.Tutorial;
import com.springboot.mongodb.project.repository.TutorialRepository;
import com.springboot.mongodb.project.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TutorialController {
    @Autowired
    private final TutorialRepository tutorialRepository;

    @Autowired
    private TutorialService tutorialService;

    public TutorialController(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
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
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
        try {
            List<Tutorial> tutorials = new ArrayList<Tutorial>();
            if (title == null)
                tutorialRepository.findAll().forEach(tutorials::add);
            else
                tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/tutorials/")
    public ResponseEntity readTutorials(@RequestParam(required = false) String title) {
        try{
            if (title == null) {
                return ResponseEntity.ok(tutorialService.readTutorials());
            }
            return ResponseEntity.ok(tutorialService.readTutorialTitle(title));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}


