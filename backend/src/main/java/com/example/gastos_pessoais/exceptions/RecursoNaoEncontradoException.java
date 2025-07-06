package com.example.gastos_pessoais.exceptions;

public class RecursoNaoEncontradoException extends  RuntimeException {
    public RecursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
