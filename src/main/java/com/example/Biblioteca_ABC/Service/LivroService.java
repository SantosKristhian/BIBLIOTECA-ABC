package com.example.Biblioteca_ABC.Service;

import com.example.Biblioteca_ABC.Model.Livro;
import com.example.Biblioteca_ABC.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> findAll() {
        return livroRepository.getLivros();
    }

    public Livro findById(Integer id) {
        return livroRepository.getLivro(id);
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public void delete(Integer id) {
        livroRepository.delete(id);
    }

    public Livro update(Integer id, Livro livroUpdate) {
        return livroRepository.update(id, livroUpdate);
    }
}
