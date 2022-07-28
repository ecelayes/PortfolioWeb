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
@Table(name = "habilidades")
public class Habilidad implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotEmpty
    @Column(name = "nombre")
    @Size(max = 15, message = "Se excede la longitud de 15 caracteres")
    private String nombre;
    
    @Column(name = "dir_icono")
    @Size(max = 255, message = "Se excede la longitud de 255 caracteres")
    private String dirIcono;
    
    @NotNull
    @Column(name = "porcentaje")
    private int porcentaje;

}
