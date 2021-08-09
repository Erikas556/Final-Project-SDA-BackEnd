package com.sda.finalprojectsda.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// class which maps a specific table from the DB
@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // added this annotation because of some weird bug which is caused by findById Get method.
public class Todo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String task;

}
