package com.example.Biblioteca_ABC.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Autor {
    private Integer id;
    private String nome;
    private String cpf;
    private int idade;
}
