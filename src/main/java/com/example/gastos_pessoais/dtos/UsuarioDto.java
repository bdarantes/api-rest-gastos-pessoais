package com.example.gastos_pessoais.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDto {
    @NotBlank(message ="O nome é obrigatório.")
    @Size(min = 2, max = 100,message = "O nome deve ter entre 2 e 100 caracteres.")
    private String nome;
}
