package com.proyecto8.biblioteca.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.proyecto8.biblioteca.Models.AutorModel;
import com.proyecto8.biblioteca.Services.AutorService;

@RestController
@RequestMapping("/autores")

public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<AutorModel>> getAllAutores(){
        return new ResponseEntity<>(autorService.getAllAutores(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorModel> getAutorById(@PathVariable Long id){
        AutorModel autor = autorService.getAutorById(id);
        if (autor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(autor,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AutorModel> saveAutor(@RequestBody AutorModel autor){
        return new ResponseEntity<>(autorService.saveAutor(autor),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id){
        if (autorService.getAutorById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        autorService.deleteAutor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  

}
