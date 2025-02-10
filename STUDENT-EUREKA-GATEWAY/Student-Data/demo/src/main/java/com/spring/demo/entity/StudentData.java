package com.spring.demo.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Collection;


@Data
@Document(collection ="student")

public class StudentData {

    @Id
    private int id;
    private String name;
    private String standard;

}
