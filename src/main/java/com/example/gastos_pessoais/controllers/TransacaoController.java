package com.example.gastos_pessoais.controllers;

import com.example.gastos_pessoais.dtos.TransacaoDto;
import com.example.gastos_pessoais.services.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {
    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<TransacaoDto> salvarTransacao(@RequestBody @Valid TransacaoDto dto) {
        TransacaoDto novaTransacao = transacaoService.salvarTransacao(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTransacao);
    }

    @GetMapping
    public ResponseEntity<List<TransacaoDto>> listarTransacoes() {
        List<TransacaoDto> transacoes = transacaoService.listarTransacoes();
        return ResponseEntity.ok(transacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            TransacaoDto transacao = transacaoService.buscarPorId(id);
            return ResponseEntity.ok(transacao);
        } catch (RuntimeException e) {
            if(e.getMessage().contains("não encontrada")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar transacao");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarTransacao(@PathVariable Long id, @RequestBody @Valid TransacaoDto dto) {
        try {
            TransacaoDto transacaoAtualizada = transacaoService.atualizarTransacao(id, dto);
            return ResponseEntity.ok(transacaoAtualizada);
        } catch (RuntimeException e) {
            if(e.getMessage().contains("não encontrada")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar transação");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deletar(@PathVariable Long id) {
        try {
            transacaoService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            if(e.getMessage().contains("não encontrada")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar transação");
        }
    }


}
