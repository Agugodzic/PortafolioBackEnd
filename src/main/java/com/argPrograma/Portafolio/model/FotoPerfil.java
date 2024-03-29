package com.argPrograma.Portafolio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FotoPerfil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String link;
}
