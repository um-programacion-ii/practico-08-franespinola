package com.proyecto8.biblioteca.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.proyecto8.biblioteca.Models.LibroModel;
import com.proyecto8.biblioteca.Repositories.LibroRepository;

public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<LibroModel> getAllLibros(){
        return libroRepository.findAll();
    }

    public LibroModel saveLibro(LibroModel libro){
        return libroRepository.save(libro);
    }

    public void deleteLibro(Long id){
        libroRepository.deleteById(id);
    }

    public LibroModel getLibroById(Long id){
        return libroRepository.findById(id).orElse(null);
    }

    public LibroModel updateLibro(LibroModel libro){
        LibroModel existingLibro = libroRepository.findById(libro.getId()).orElse(null);
        existingLibro.setTitulo(libro.getTitulo());
        existingLibro.setIsbn(libro.getIsbn());
        existingLibro.setAutor(libro.getAutor());
        return libroRepository.save(existingLibro);
    }
        
}
