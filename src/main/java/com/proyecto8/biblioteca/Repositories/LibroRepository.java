package com.proyecto8.biblioteca.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto8.biblioteca.Models.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{
    //derived query methods
    List<Libro> findByTitulo(String titulo);
    
    // JPQL query
    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    List<Libro> findByTituloJPQL(@Param("titulo") String titulo);
    

}
