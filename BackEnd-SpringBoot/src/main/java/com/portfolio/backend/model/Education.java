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
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String institution;
    private String degree;
    private String career;
    private String startDate;
    private String endDate;
    private String dirIcon;
    
    //Constructor

    public Education(String institution, String degree, String career, String startDate, String endDate, String dirIcon) {
        this.institution = institution;
        this.degree = degree;
        this.career = career;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dirIcon = dirIcon;
    }
    
}
