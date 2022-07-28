package com.portfolio.backend.models;

import com.sun.istack.NotNull;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "experiences")
public class Experience implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotEmpty
    @Column(name = "company")
    @Size(max = 50, message = "Se excede la longitud de 50 caracteres")
    private String company;
    
    @NotEmpty
    @Column(name = "position")
    @Size(max = 100, message = "Se excede la longitud de 100 caracteres")
    private String position;
    
    @NotNull
    @Column(name = "start_date")
    @Size(max = 10, message = "Se excede la longitud de 10 caracteres")
    private String startDate;
    
    @Column(name = "end_date")
    @Size(max = 10, message = "Se excede la longitud de 10 caracteres")
    private String endDate;
    
    @NotEmpty
    @Column(name = "description")
    @Size(max = 255, message = "Se excede la longitud de 255 caracteres")
    private String description;
    
    @Column(name = "dir_icon")
    @Size(max = 255, message = "Se excede la longitud de 255 caracteres")
    private String dirIcon;
    
}
