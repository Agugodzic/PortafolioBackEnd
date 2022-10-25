package com.argPrograma.Portafolio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Proyectos {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String titulo;
    private boolean terminado;
    private String descripcion;
    private String linkRepository;
    private String linkPreview;
    private String linkImagen;
}
