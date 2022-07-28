package com.portfolio.backend.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
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
@Table(name = "persons")
public class Person implements Serializable {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;
    
    @NotEmpty
    @Column(name = "name")
    @Size(max = 10, message = "Se excede la longitud de 10 caracteres")
    private String name;
    
    @NotEmpty
    @Column(name = "surname")
    @Size(max = 10, message = "Se excede la longitud de 10 caracteres")
    private String surname;
    
    @NotEmpty
    @Column(name = "title")
    @Size(max = 50, message = "Se excede la longitud de 50 caracteres")
    private String title;
        
    @NotEmpty
    @Column(name = "location")
    @Size(max = 125, message = "Se excede la longitud de 125 caracteres")
    private String location;
    
    @NotEmpty
    @Email
    @Column(name = "email")
    @Size(max = 50, message = "Se excede la longitud de 50 caracteres")
    private String email;
    
    @NotEmpty
    @Column(name = "description")
    @Size(max = 255, message = "Se excede la longitud de 255 caracteres")
    private String description;
    
    @NotEmpty
    @Column(name = "dir_photo")
    @Size(max = 255, message = "Se excede la longitud de 255 caracteres")
    private String dirPhoto;
    
    //Relaciones entre modelos unidimencionales
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "personas_id")
    private Set<Education> educaciones = new HashSet<>();
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "personas_id")
    private Set<Experience> experiencias = new HashSet<>();
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "personas_id")
    private Set<Skills> habilidades = new HashSet<>();
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "personas_id")
    private Set<Project> proyectos = new HashSet<>();
}