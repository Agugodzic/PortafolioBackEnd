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

public class Habilidades {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String habilidad;
    private int nivel;
}

