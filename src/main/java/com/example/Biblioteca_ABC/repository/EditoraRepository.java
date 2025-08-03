package com.example.Biblioteca_ABC.repository;

import com.example.Biblioteca_ABC.Model.Editora;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EditoraRepository {
    private final List<Editora> editoras = new ArrayList<>();
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public List<Editora> getEditoras() {
        return Collections.unmodifiableList(editoras);//isso significa apenas pra vc ver os dados e nao alteralso
    }

    public Editora getEditora(Integer id) {
        for (Editora editora : editoras) {
            if (editora.getId().equals(id)) {
                return editora;
            }
        }
        return null;
    }

    @PostConstruct
    public void init() {
        Editora editora = new Editora();
        editora.setId(1);
        editora.setNome("Editora Genérica");
        editora.setTelefone("45 999-999");
        editora.setEndereco("Rua Exemplo, 123");

        editoras.add(editora);
    }

    public Editora save(Editora editora) {
        atomicInteger.incrementAndGet();
        editora.setId(atomicInteger.get());
        editoras.add(editora);
        return editora;
    }

    public void delete(Integer id) {
        editoras.removeIf(editora -> editora.getId().equals(id));
    }

    public Editora update(Integer id, Editora editoraUpdate) {
        for (Editora editora : editoras) {
            if (editora.getId().equals(id)) {
                editora.setNome(editoraUpdate.getNome());
                editora.setTelefone(editoraUpdate.getTelefone());
                editora.setEndereco(editoraUpdate.getEndereco());
                return editora;
            }
        }
        return null;
    }
}
