package com.proyecto8.biblioteca.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto8.biblioteca.Models.Libro;
import com.proyecto8.biblioteca.Repositories.LibroRepository;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;


    // metodo para obtener todos los libros
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    // metodo para obtener un libro por id
    public Libro getLibroById(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    // metodo para guardar un libro
    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    // metodo para eliminar un libro
    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }

    // metodo para actualizar un libro
    public Libro updateLibro(Libro libro) {
        return libroRepository.save(libro);
    }


}

