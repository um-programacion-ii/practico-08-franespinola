package com.proyecto8.biblioteca.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto8.biblioteca.Models.Autor;
import com.proyecto8.biblioteca.Repositories.AutorRepository;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    // metodo para obtener todos los autores
    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    // metodo para obtener un autor por id
    public Autor getAutorById(Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    // metodo para guardar un autor
    public Autor saveAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    // metodo para eliminar un autor
    public void deleteAutor(Long id) {
        autorRepository.deleteById(id);
    }

    // metodo para actualizar un autor
    public Autor updateAutor(Autor autor) {
        return autorRepository.save(autor);     
    }
    

}
