package com.springboot.mongodb.project.controller;

import com.mongodb.client.MongoClient;
import com.springboot.mongodb.project.model.Tutorial;
import com.springboot.mongodb.project.repository.TutorialRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping
    public String testController(){
        return "mongodb";
    }
}
