package com.example.gastos_pessoais.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransacaoDto {
    @NotBlank(message="A descrição é obrigatória.")
    @Size(max = 255, message ="A descrição deve ter no máximo 255 caracteres.")
    private String descricao;

    @NotNull(message = "O valor é obrigatório.")
    @DecimalMin(value="0.01", inclusive = true, message="O valor deve ser maior que zero.")

    private BigDecimal valor;

    @NotNull(message = "A data é obrigatória.")
    @PastOrPresent(message = "A data não pode ser futura.")
    private LocalDate data;

    public  TransacaoDto() {

    }

    public TransacaoDto(String descricao, BigDecimal valor, LocalDate data) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}

