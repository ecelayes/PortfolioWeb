package com.portfolio.backend.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "persona")
public class Persona implements Serializable {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona", updatable=false)
    private Long id;
    
    @NotEmpty
    @Column(name = "nombre")
    private String nombre;
    
    @NotEmpty
    @Column(name = "apellido")
    private String apellido;
    
    @NotEmpty
    @Column(name = "titulo")
    private String titulo;
    
    @NotEmpty
    @Column(name = "localidad")
    private String localidad;
    
    @NotEmpty
    @Email
    @Column(name = "email")
    private String email;
    
    @NotEmpty
    @Column(name = "descripcion")
    @Size(max = 200, message = "Se excede la longitud de 200 caracteres")
    private String descripcion;
    
    @NotEmpty
    @Column(name = "dir_foto")
    private String dirFoto;

    //Relaciones entre modelos
    
    @OneToMany(mappedBy = "personaEducacion", cascade = CascadeType.ALL)
    private List<Educacion> educaciones;
    
    @OneToMany(mappedBy = "personaExperiencia", cascade = CascadeType.ALL)
    private List<Experiencia> experiencias;
    
    @OneToMany(mappedBy = "personaHabilidad", cascade = CascadeType.ALL)
    private List<Habilidad> habilidades;
    
    @OneToMany(mappedBy = "personaProyecto", cascade = CascadeType.ALL)
    private List<Proyecto> proyectos;
}
