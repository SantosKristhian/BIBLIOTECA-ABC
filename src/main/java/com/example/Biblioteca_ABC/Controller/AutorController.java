package com.example.Biblioteca_ABC.Controller;

import com.example.Biblioteca_ABC.Model.Autor;
import com.example.Biblioteca_ABC.Service.AutorService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/biblioteca")

public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService){
        this.autorService = autorService;
    }

    @PostMapping("/save")
    public ResponseEntity<Autor> save(
            @RequestBody Autor autor){
        try{
            var result = autorService.save(autor);
            return new ResponseEntity<>(result,
                    HttpStatus.CREATED);
        }
        catch (Exception ex){
            return new ResponseEntity<>(null,
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Autor>> findAll(){
        try{
            var result = autorService.findAll();
            return new ResponseEntity<>(result,
                    HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


}
