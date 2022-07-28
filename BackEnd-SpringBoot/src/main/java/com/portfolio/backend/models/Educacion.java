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
@Table(name = "educaciones")
public class Educacion implements Serializable {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotEmpty
    @Column(name = "institucion")
    @Size(max = 50, message = "Se excede la longitud de 50 caracteres")
    private String institucion;
    
    @NotEmpty
    @Column(name = "titulo")
    @Size(max = 50, message = "Se excede la longitud de 50 caracteres")
    private String titulo;
    
    @NotEmpty
    @Column(name = "carrera")
    @Size(max = 50, message = "Se excede la longitud de 50 caracteres")
    private String carrera;
    
    @NotEmpty
    @Column(name = "fecha_inicio")
    @Size(max = 10, message = "Se excede la longitud de 10 caracteres")
    private String fechaInicio;
    
    @Column(name = "fecha_fin")
    @Size(max = 10, message = "Se excede la longitud de 10 caracteres")
    private String fechaFin;
    
    @NotEmpty
    @Column(name = "dir_icono")
    @Size(max = 255, message = "Se excede la longitud de 255 caracteres")
    private String dirIcono;
    
}
