package com.proyecto8.biblioteca.Models;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter @NoArgsConstructor
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String nacionalidad;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)  // en mappedBy coloco el nombre que le voy a dar a la relacion el cual debe ser igual al nombre del campo en la otra entidad
    @JsonManagedReference //con esta anotacion evito que se genere un bucle infinito al momento de hacer la consulta
    private List<Libro> libros = new ArrayList<>();

}
