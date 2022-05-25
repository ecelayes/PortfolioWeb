package com.portfolio.backend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Table;
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
@Table(name = "educaciones")
public class Educacion implements Serializable {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
    
    @NotEmpty
    @Column(name = "fecha_inicio")
    private String fechaInicio;
    
    @Column(name = "fecha_fin")
    private String fechaFin;
    
    @NotEmpty
    @Column(name = "dir_icono")
    private String dirIcono;
    
}
