package com.example.Biblioteca_ABC.repository;

import com.example.Biblioteca_ABC.Model.Livro;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class LivroRepository {
    private final List<Livro> livros = new ArrayList<>();
    private final AtomicInteger atomicInteger = new AtomicInteger(10);

    public List<Livro> getLivros() {
        return Collections.unmodifiableList(livros); // Isso significa que a lista não pode ser alterada externamente
    }

    public Livro getLivro(Integer id) {
        for (Livro livro : livros) {
            if (livro.getId().equals(id)) {
                return livro;
            }
        }
        return null;
    }

    @PostConstruct
    public void init() {
        Livro livro = new Livro();
        livro.setId(1);
        livro.setISSN("1234-5678");
        livro.setTitulo("Título Genérico");
        livro.setSinopse("Sinopse do livro genérico.");
        livro.setAno(2023);
        livro.setNumeroPaginas(200);

        livros.add(livro);
    }

    public Livro save(Livro livro) {
        atomicInteger.incrementAndGet();
        livro.setId(atomicInteger.get());
        livros.add(livro);
        return livro;
    }

    public void delete(Integer id) {
        livros.removeIf(livro -> livro.getId().equals(id));
    }

    public Livro update(Integer id, Livro livroUpdate) {
        for (Livro livro : livros) {
            if (livro.getId().equals(id)) {
                livro.setISSN(livroUpdate.getISSN());
                livro.setTitulo(livroUpdate.getTitulo());
                livro.setSinopse(livroUpdate.getSinopse());
                livro.setAno(livroUpdate.getAno());
                livro.setNumeroPaginas(livroUpdate.getNumeroPaginas());
                return livro;
            }
        }
        return null;
    }
}
