package com.example.Biblioteca_ABC.Service;

import com.example.Biblioteca_ABC.Model.Autor;
import com.example.Biblioteca_ABC.Model.Biblioteca;
import com.example.Biblioteca_ABC.repository.BibliotecaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {

    public BibliotecaService(BibliotecaRepository bibliotecaRepository){
        this.bibliotecaRepository = bibliotecaRepository;
    }

    private final BibliotecaRepository bibliotecaRepository;

    public List<Biblioteca> findAll(){
        return bibliotecaRepository.getBibliotecas();
    }

    public Biblioteca save (Biblioteca biblioteca){
        return bibliotecaRepository.save(biblioteca);
    }


    public Biblioteca findById(Integer id) {
        return bibliotecaRepository.getBiblioteca(id);
    }

        public void delete(Integer id) {
        bibliotecaRepository.delete(id);
    }

    public Biblioteca update(Integer id, Biblioteca bibliotecaUpdate) {
        return bibliotecaRepository.update(id, bibliotecaUpdate);
    }




}
