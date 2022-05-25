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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "experiencias")
public class Experiencia implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotEmpty
    @Column(name = "empresa")
    private String empresa;
    
    @NotEmpty
    @Column(name = "cargo")
    private String cargo;
    
    @NotNull
    @Column(name = "fecha_inicio")
    private String fechaInicio;
    
    @Column(name = "fecha_fin")
    private String fechaFin;
    
    @NotEmpty
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "dir_icono")
    private String dirIcono;
    
}
