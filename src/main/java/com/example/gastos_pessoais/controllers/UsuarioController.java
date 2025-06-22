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
    public ResponseEntity<UsuarioDto> salvar(@RequestBody @Valid UsuarioDto usuarioDto) {
        UsuarioDto usuarioSalvo = usuarioService.salvarUsuario(usuarioDto);
        return  new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<UsuarioDto>>listarUsuarios() {
        List<UsuarioDto> usuarios = usuarioService.listarUsuarios();
        return  new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto>buscarPorId(@PathVariable Long id) {
        UsuarioDto usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto>atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto) {
        UsuarioDto usuarioAtualizado = usuarioService.atualizarUsuario(id, usuarioDto);
        if(usuarioAtualizado !=null) {
            return  new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        if(usuarioService !=null) {
            return  ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
