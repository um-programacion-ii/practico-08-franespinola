package com.proyecto8.biblioteca.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto8.biblioteca.Models.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{

}
