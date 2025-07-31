package com.example.Biblioteca_ABC.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Livro {
    private Integer id;
    private String ISSN;
    private String titulo;
    private String sinopse;
    private int ano;
    private int numeroPaginas;
}
