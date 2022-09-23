package com.springboot.mongodb.project.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "tutorials")
@Data
public class Tutorial {

    @Id
    private String id;
    private String title;
    private String description;
    private boolean publiched;

    public Tutorial(String title, String description, boolean publiched) {
        this.title = title;
        this.description = description;
        this.publiched = publiched;
    }
}
