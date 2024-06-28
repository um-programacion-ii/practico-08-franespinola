package com.proyecto8.biblioteca.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.proyecto8.biblioteca.Models.AutorModel;
import com.proyecto8.biblioteca.Repositories.AutorRepository;

public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<AutorModel> getAllAutores(){
        return autorRepository.findAll();
    }

    public AutorModel saveAutor(AutorModel autor){
        return autorRepository.save(autor);
    }

    public void deleteAutor(Long id){
        autorRepository.deleteById(id);
    }

    public AutorModel getAutorById(Long id){
        return autorRepository.findById(id).orElse(null);
    }

    public AutorModel updateAutor(AutorModel autor){
        AutorModel existingAutor = autorRepository.findById(autor.getId()).orElse(null);
        existingAutor.setNombre(autor.getNombre());
        existingAutor.setNacionalidad(autor.getNacionalidad());
        return autorRepository.save(existingAutor);
    }
}
