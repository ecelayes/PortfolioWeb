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
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameProject;
    private String dirImage;
    private String startDate;
    private String endDate;
    private String description;
    private String link;
    
    //Constructor

    public Project(String nameProject, String dirImage, String startDate, String endDate, String description, String link) {
        this.nameProject = nameProject;
        this.dirImage = dirImage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.link = link;
    }
    
}
