package com.example.gastos_pessoais.controllers;

import com.example.gastos_pessoais.dtos.TransacaoDto;
import com.example.gastos_pessoais.dtos.UsuarioDto;
import com.example.gastos_pessoais.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity<UsuarioDto> salvarUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        UsuarioDto usuarioSalvo = usuarioService.salvarUsuario(usuarioDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    @GetMapping
    public  ResponseEntity<List<UsuarioDto>>listarUsuarios() {
        List<UsuarioDto> usuarios = usuarioService.listarUsuarios();
        return  ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>buscarPorId(@PathVariable Long id) {
           UsuarioDto usuario = usuarioService.buscarPorId(id);
           return ResponseEntity.ok(usuario);

    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?>atualizarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioDto usuarioDto) {
            UsuarioDto usuarioAtualizado = usuarioService.atualizarUsuario(id, usuarioDto);
            return ResponseEntity.ok(usuarioAtualizado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletar(@PathVariable Long id) {
            usuarioService.deletar(id);
            return ResponseEntity.noContent().build();

    }

}
