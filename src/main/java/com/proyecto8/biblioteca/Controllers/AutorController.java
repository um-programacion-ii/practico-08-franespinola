package com.proyecto8.biblioteca.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.proyecto8.biblioteca.Models.Autor;
import com.proyecto8.biblioteca.Services.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {
    
    @Autowired
    private AutorService autorService;

    // metodo para obtener todos los autores
    @GetMapping
    public List<Autor> getAllAutores() {
        return autorService.getAllAutores();
    }

    // metodo para obtener un autor por id
    @GetMapping("/{id}")
    public Autor getAutorById(@PathVariable Long id) {
        return autorService.getAutorById(id);
    }

    // metodo para guardar un autor
    @PostMapping
    public Autor saveAutor(@RequestBody Autor autor) {
        return autorService.saveAutor(autor);
    }

    // metodo para eliminar un autor
    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable Long id) {
        autorService.deleteAutor(id);
    }

    // metodo para actualizar un autor
    @PutMapping("/{id}")
    public Autor updateAutor(@PathVariable Long id,@RequestBody Autor autor){
        Autor autorToUpdate = autorService.getAutorById(id);
        if (autorToUpdate != null) {
            autorToUpdate.setNombre(autor.getNombre());
            autorToUpdate.setNacionalidad(autor.getNacionalidad());
            return autorService.updateAutor(autorToUpdate);
        } else {
            // Handle error when autor with given id does not exist
            throw new RuntimeException("Autor not found with id: " + id);
        }

    }
        
  

}

