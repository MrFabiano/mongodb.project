package com.springboot.mongodb.project.service;

import com.springboot.mongodb.project.model.Endereco;
import com.springboot.mongodb.project.model.Tutorial;
import com.springboot.mongodb.project.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Tutorial> buscarTutotorial(Tutorial tutorial, String title, String description, boolean publiched){
       List<Tutorial> listTutorial = tutorialRepository.findByTitleContaining(title, description, false);
        if(listTutorial!=null && listTutorial.isEmpty()){
            tutorialRepository.save(tutorial);
        }else{
            tutorialRepository.findByTitleContaining(title, description, false);
        }
        return listTutorial;
    }

    @Bean
    public CommandLineRunner run(ViaCEPClient client){
        return args -> {
            if(args.length > 0){
                String cep = args[0];

                Endereco endereco = client.buscaEnderecoPor(cep);

                System.out.println(endereco);
            }
        };
    }
}
