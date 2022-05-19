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
@Table(name = "habilidad")
public class Habilidad implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habilidad")
    private Long id;
    
    @NotEmpty
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "dir_icono")
    private String dirIcono;
    
    @NotNull
    @Column(name = "porcentaje")
    private int porcentaje;
    
    //Relaciones  entre modelos
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_habilidad")
    private Persona personaHabilidad;
}
