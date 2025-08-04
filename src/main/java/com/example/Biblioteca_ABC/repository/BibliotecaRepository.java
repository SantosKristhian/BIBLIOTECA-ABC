package com.example.Biblioteca_ABC.repository;

import com.example.Biblioteca_ABC.Model.Biblioteca;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class BibliotecaRepository {
    private final List<Biblioteca> bibliotecas = new ArrayList<>();

    private final AtomicInteger atomicInteger = new AtomicInteger(10);

    public List<Biblioteca> getBibliotecas(){
        return Collections.unmodifiableList(bibliotecas);
    }

    public Biblioteca getBiblioteca(Integer id){
        for (Biblioteca biblioteca : bibliotecas){
            if (biblioteca.getId().equals(id)){
                return biblioteca;
            }
        }
        return null;
    }
    @PostConstruct
    public void init(){
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setId(1);
        biblioteca.setNome("Genérica");
        biblioteca.setTelefone("45 999-999");

        bibliotecas.add(biblioteca);
    }

    public Biblioteca save (Biblioteca biblioteca){
        atomicInteger.incrementAndGet();
        biblioteca.setId(atomicInteger.get());
        bibliotecas.add(biblioteca);
        return biblioteca;
    }

    public void delete(Integer id) {
        for (Biblioteca biblioteca : bibliotecas) {
            if (biblioteca.getId().equals(id)) {
                bibliotecas.remove(biblioteca);
                return; // sair do loop
            }
        }
    }

    public Biblioteca update(Integer id, Biblioteca bibliotecaUpdate) {
        for (Biblioteca biblioteca : bibliotecas) {
            if (biblioteca.getId().equals(id)) {
                // nome e marca podem correr risco de ser null
                // interessante validar antes de fazer o SET
                biblioteca.setNome(bibliotecaUpdate.getNome());
                biblioteca.setTelefone(bibliotecaUpdate.getTelefone());
                return biblioteca;
            }
        }
        return null;
    }
}
