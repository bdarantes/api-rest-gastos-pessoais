package com.example.gastos_pessoais.repositories;

import com.example.gastos_pessoais.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
