package com.springboot.mongodb.project.controller;


import com.springboot.mongodb.project.model.Endereco;
import com.springboot.mongodb.project.service.ViaCEPClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("v1/cep/")
public class CepController {

    @Autowired
    private ViaCEPClient client;


    @GetMapping(value = "ws/{cep}/json", produces = "application/json")
    public ResponseEntity<Endereco> getCepList(@PathVariable String cep){

//        return Optional.of(client.buscaEnderecoPor(cep))
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());

        return new ResponseEntity<>(Objects.requireNonNull(client.buscaEnderecoPor(cep)), HttpStatus.OK);
    }
}
