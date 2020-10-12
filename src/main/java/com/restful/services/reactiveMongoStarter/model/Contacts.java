package com.restful.services.reactiveMongoStarter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Contacts {
    @Id
    private String id;
    
    private String name;
    private String email;
}
