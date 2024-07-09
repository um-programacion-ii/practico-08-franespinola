package com.proyecto8.biblioteca.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.proyecto8.biblioteca.Models.Libro;
import com.proyecto8.biblioteca.Services.LibroService;


@RestController
@RequestMapping("/libros")
public class LibroController {
    
    @Autowired
    private LibroService libroService;

    // metodo para obtener todos los libros
    @GetMapping
    public List<Libro> getAllLibros() {
        return libroService.getAllLibros();
    }

    // metodo para obtener un libro por id
    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable Long id) {
        return libroService.getLibroById(id);
    }

    // metodo para obtener un libro por titulo usando derived query methods
    @GetMapping("/titulo-derived/{titulo}")
    public List<Libro> getLibroByTitulo(@PathVariable String titulo) {
        return libroService.getLibroByTitulo(titulo);
    }

    //metodo para obtener un libro por titulo usando JPQL query
    @GetMapping("/titulo-JPQL/{titulo}")
    public List<Libro> getLibroByTituloCriteria(@PathVariable String titulo) {
        return libroService.getLibroByTituloCriteria(titulo);
    }


    // metodo para guardar un libro
    @PostMapping
    public Libro saveLibro(@RequestBody Libro libro) {
        return libroService.saveLibro(libro);
    }

    // metodo para eliminar un libro
    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
    }

    // metodo para actualizar un libro
    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable Long id ,@RequestBody Libro libro) {
        Libro libroToUpdate = libroService.getLibroById(id);
        if (libroToUpdate != null) {
            libroToUpdate.setIsbn(libro.getIsbn());
            libroToUpdate.setTitulo(libro.getTitulo());
            return libroService.updateLibro(libroToUpdate);
        }else{
            // Handle error when libro with given id does not exist
            throw new RuntimeException("Libro not found with id: " + id);
        }
    }

}

