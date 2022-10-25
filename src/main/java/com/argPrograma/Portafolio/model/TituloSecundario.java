package com.argPrograma.Portafolio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TituloSecundario {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String institucion;
}