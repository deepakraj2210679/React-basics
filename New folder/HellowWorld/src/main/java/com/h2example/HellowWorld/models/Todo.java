package com.h2example.HellowWorld.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Todo {

    @Id
    @GeneratedValue
    Long id;
    String title;
    String Description;
    Boolean isComplete;


    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

//    public String getDescription() {
//        return Description;
//    }
//
//    public void setDescription(String description) {
//        Description = description;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
}
