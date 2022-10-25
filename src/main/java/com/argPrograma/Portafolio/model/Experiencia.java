package com.argPrograma.Portafolio.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Experiencia {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String puesto;
    private String empresa;
    private int tiempo;
    private String unidad;
}
