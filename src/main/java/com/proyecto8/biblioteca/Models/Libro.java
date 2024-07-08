package com.proyecto8.biblioteca.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, unique = true)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "fk_autor_id", nullable = false) // en joinColumn coloco el nombre de la columna que va a hacer referencia a la otra entidad
    @JsonBackReference // con esta anotacion evito que se genere un bucle infinito al momento de hacer la consulta
    private Autor autor; // campo autor que hace referencia a la relacion con la entidad autormodel

}
