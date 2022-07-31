package com.portfolio.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String title;
    private String location;
    
    private String description;
    private String dirPhoto;
    private String dirBanner;
    
    //Constructor

    public Person(String name, String surname, String title, String location, String description, String dirPhoto, String dirBanner) {
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.location = location;
        this.description = description;
        this.dirPhoto = dirPhoto;
        this.dirBanner = dirBanner;
    }
    
}
