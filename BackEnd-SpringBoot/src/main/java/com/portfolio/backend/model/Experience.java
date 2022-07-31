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
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String position;
    private String startDate;
    private String endDate;
    private String description;
    private String dirIcon;
    
    //Constructor

    public Experience(String company, String position, String startDate, String endDate, String description, String dirIcon) {
        this.company = company;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.dirIcon = dirIcon;
    }
    
}
