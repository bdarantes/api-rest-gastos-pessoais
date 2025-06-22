package com.example.gastos_pessoais.repositories;

import com.example.gastos_pessoais.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
