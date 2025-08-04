package com.example.Biblioteca_ABC.Service;

import com.example.Biblioteca_ABC.Model.Editora;
import com.example.Biblioteca_ABC.repository.EditoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {
    private final EditoraRepository editoraRepository;

    public EditoraService(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    public List<Editora> findAll() {
        return editoraRepository.getEditoras();
    }

    public Editora findById(Integer id) {
        return editoraRepository.getEditora(id);
    }

    public Editora save(Editora editora) {
        return editoraRepository.save(editora);
    }

    public void delete(Integer id) {
        editoraRepository.delete(id);
    }

    public Editora update(Integer id, Editora editoraUpdate) {
        return editoraRepository.update(id, editoraUpdate);
    }
}
