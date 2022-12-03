package com.springboot.mongodb.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Endereco {

    @JsonProperty("cep")
    private String cep;
    @JsonProperty("logradouro")
    private String logradouro;
    @JsonProperty("complemento")
    private String complemento;
    @JsonProperty("numero")
    private String numero;
    @JsonProperty("bairro")
    private String bairro;
    @JsonProperty("localidade")
    private String localidade;
    @JsonProperty("uf")
    private String uf;
}


