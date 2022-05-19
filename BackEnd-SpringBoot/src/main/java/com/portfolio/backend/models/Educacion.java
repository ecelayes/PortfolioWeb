package com.portfolio.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import com.sun.istack.NotNull;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "educacion")
public class Educacion implements Serializable {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_educacion")
    private Long id;
    
    @NotEmpty
    @Column(name = "institucion")
    private String institucion;
    
    @NotEmpty
    @Column(name = "titulo")
    private String titulo;
    
    @NotEmpty
    @Column(name = "carrera")
    private String carrera;
    
    @NotNull
    @Column(name = "fecha_inicio")
    private int fechaInicio;
    
    @NotNull
    @Column(name = "fecha_fin")
    private int fechaFin;
    
    @Column(name = "dir_icono")
    private String dirIcono;
    
    //Relaciones  entre modelos
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_educacion")
    private Persona personaEducacion;
}
