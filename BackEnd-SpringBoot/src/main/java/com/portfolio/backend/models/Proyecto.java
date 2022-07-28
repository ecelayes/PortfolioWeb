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
@Table(name = "proyectos")
public class Proyecto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotEmpty
    @Column(name = "nombre")
    @Size(max = 100, message = "Se excede la longitud de 100 caracteres")
    private String nombre;
    
    @NotEmpty
    @Column(name = "dir_imagen")
    @Size(max = 255, message = "Se excede la longitud de 255 caracteres")
    private String dirImagen;
    
    @NotNull
    @Column(name = "fecha_inicio")
    @Size(max = 10, message = "Se excede la longitud de 10 caracteres")
    private String fechaIncio;
    
    @Column(name = "fecha_fin")
    @Size(max = 10, message = "Se excede la longitud de 10 caracteres")
    private String fechaFin;
    
    @NotEmpty
    @Column(name = "descripcion")
    @Size(max = 255, message = "Se excede la longitud de 255 caracteres")
    private String descripcion;
    
    @Column(name = "link")
    @Size(max = 255, message = "Se excede la longitud de 255 caracteres")
    private String link;
    
}
