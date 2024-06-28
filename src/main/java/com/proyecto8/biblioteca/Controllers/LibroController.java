package com.proyecto8.biblioteca.Controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto8.biblioteca.Models.LibroModel;
import com.proyecto8.biblioteca.Services.LibroService;


@RestController
@RequestMapping("/libros")    

public class LibroController {
    @Autowired
    private LibroService libroService;
    
    @GetMapping
    public ResponseEntity<List<LibroModel>> getAllLibros(){
        return new ResponseEntity<>(libroService.getAllLibros(),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<LibroModel> saveLibro(@RequestBody LibroModel libro){
        return new ResponseEntity<>(libroService.saveLibro(libro),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long id){
        libroService.deleteLibro(id);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<LibroModel> getLibroById(@PathVariable Long id){
        LibroModel libro = libroService.getLibroById(id);
        if (libro == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(libro,HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<LibroModel> updateLibro(@PathVariable Long id, @RequestBody LibroModel libro){
        if (libroService.getLibroById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        libro.setId(id);
        return new ResponseEntity<>(libroService.updateLibro(libro),HttpStatus.OK);
    }
}

