package com.student.consumer.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "StudentData")
@Data
public class StudentData {
    private int id;
    private String name;
    private String standard;
}
