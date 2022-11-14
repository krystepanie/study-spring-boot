package com.tutorial.music.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Data
public class Wish {

    private String id;

    private String title;
    private String description;
    private String category;
    private Set<String> tags;

}
