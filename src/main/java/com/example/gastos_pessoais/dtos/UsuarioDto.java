package com.example.gastos_pessoais.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDto {
    @NotBlank(message ="O nome é obrigatório.")
    @Size(min = 2, max = 100,message = "O nome deve ter entre 2 e 100 caracteres.")
    private String nome;

    public UsuarioDto() {

    }

    public UsuarioDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
