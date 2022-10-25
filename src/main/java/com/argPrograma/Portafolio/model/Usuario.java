package com.argPrograma.Portafolio.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Info> info;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<DatosDeUsuario> datosDeUsuario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Experiencia> experiencia;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Habilidades> habilidades;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Cursos> cursos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Proyectos> proyectos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<TituloUniversitario> universitario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<TituloTerciario> terciario;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<UniversitarioEnCurso> universitarioEnCurso;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<TituloSecundario> secundario;

}
