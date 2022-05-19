package com.portfolio.backend.models;

import com.sun.istack.NotNull;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "experiencia")
public class Experiencia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_experiencia")
    private Long id;
    
    @NotEmpty
    @Column(name = "empresa")
    private String empresa;
    
    @NotEmpty
    @Column(name = "cargo")
    private String cargo;
    
    @NotNull
    @Column(name = "fecha_inicio")
    private int fechaInicio;
    
    @Column(name = "fecha_fin")
    private int fechaFin;
    
    @NotEmpty
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "dir_icono")
    private String dirIcono;
    
    //Relaciones  entre modelos
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_experiencia")
    private Persona personaExperiencia;
}
