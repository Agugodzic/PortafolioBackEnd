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

public class Info {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private String perfil;
    private String portada;
    private String sobremi;
    private String nombre;
    private String apellido;
    private int edad;
    private String pais;
    private String nacionalidad;
    private String ciudad;
    private String codigopostal;
    private String email;
    private String telefono;
    private String titulo;
    private String otro;
}
