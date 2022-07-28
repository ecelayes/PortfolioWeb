package com.portfolio.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "educations")
public class Education implements Serializable {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotEmpty
    @Column(name = "institution")
    @Size(max = 50, message = "Se excede la longitud de 50 caracteres")
    private String institution;
    
    @NotEmpty
    @Column(name = "degree")
    @Size(max = 50, message = "Se excede la longitud de 50 caracteres")
    private String degree;
    
    @NotEmpty
    @Column(name = "career")
    @Size(max = 50, message = "Se excede la longitud de 50 caracteres")
    private String career;
    
    @NotEmpty
    @Column(name = "start_date")
    @Size(max = 10, message = "Se excede la longitud de 10 caracteres")
    private String startDate;
    
    @Column(name = "end_date")
    @Size(max = 10, message = "Se excede la longitud de 10 caracteres")
    private String endDate;
    
    @NotEmpty
    @Column(name = "dir_icon")
    @Size(max = 255, message = "Se excede la longitud de 255 caracteres")
    private String dirIcon;
    
}
