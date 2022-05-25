package com.portfolio.backend.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "personas")
public class Persona implements Serializable {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable=false)
    private Long id;
    
    @NotEmpty
    @Column(name = "nombre")
    @Size(max = 10, message = "Se excede la longitud de 10 caracteres")
    private String nombre;
    
    @NotEmpty
    @Column(name = "apellido")
    @Size(max = 10, message = "Se excede la longitud de 10 caracteres")
    private String apellido;
    
    @NotEmpty
    @Column(name = "titulo")
    @Size(max = 50, message = "Se excede la longitud de 50 caracteres")
    private String titulo;
        
    @NotEmpty
    @Column(name = "localidad")
    @Size(max = 125, message = "Se excede la longitud de 125 caracteres")
    private String localidad;
    
    @NotEmpty
    @Email
    @Column(name = "email")
    @Size(max = 50, message = "Se excede la longitud de 50 caracteres")
    private String email;
    
    @NotEmpty
    @Column(name = "descripcion")
    @Size(max = 255, message = "Se excede la longitud de 255 caracteres")
    private String descripcion;
    
    @NotEmpty
    @Column(name = "dir_foto")
    @Size(max = 255, message = "Se excede la longitud de 255 caracteres")
    private String dirFoto;

    //Relaciones entre modelos unidimencionales
  
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "personas_id")
    private List<Educacion> educaciones;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "personas_id")
    private List<Experiencia> experiencias;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "personas_id")
    private List<Habilidad> habilidades;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "personas_id")
    private List<Proyecto> proyectos;
}
