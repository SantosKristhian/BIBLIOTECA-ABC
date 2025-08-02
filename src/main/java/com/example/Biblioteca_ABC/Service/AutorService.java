package com.example.Biblioteca_ABC.Service;

import com.example.Biblioteca_ABC.Model.Autor;
import com.example.Biblioteca_ABC.Model.Biblioteca;
import com.example.Biblioteca_ABC.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    public AutorService(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    private final AutorRepository autorRepository;

    public List<Autor> findAll(){
        return autorRepository.getAutores();
    }

    public Autor save (Autor autor){
        return autorRepository.save(autor);
    }


    public Autor findById(Integer id) {
        return autorRepository.getAutor(id);
    }

    public void delete(Integer id) {
        autorRepository.delete(id);
    }

    public Autor update(Integer id, Autor autorUpdate) {
        return autorRepository.update(id, autorUpdate);
    }
}
