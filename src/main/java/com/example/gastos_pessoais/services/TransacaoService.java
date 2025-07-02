package com.example.gastos_pessoais.services;

import com.example.gastos_pessoais.dtos.TransacaoDto;
import com.example.gastos_pessoais.mappers.TransacaoMapper;
import com.example.gastos_pessoais.models.Transacao;
import com.example.gastos_pessoais.repositories.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final TransacaoMapper transacaoMapper;

    public TransacaoService(TransacaoRepository transacaoRepository, TransacaoMapper transacaoMapper) {
        this.transacaoRepository = transacaoRepository;
        this.transacaoMapper = transacaoMapper;
    }
    public TransacaoDto salvarTransacao(TransacaoDto transacaoDto) {
        Transacao transacao = transacaoMapper.toEntity(transacaoDto);
        Transacao transacaoSalva = transacaoRepository.save(transacao);
        return transacaoMapper.toDto(transacaoSalva);
    }
    public List<TransacaoDto> listarTransacoes() {
        return transacaoRepository.findAll()
                .stream()
                .map(transacaoMapper::toDto)
                .collect(Collectors.toList());
    }
    public TransacaoDto buscarPorId(Long id) {
        return transacaoRepository.findById(id)
                .map(transacaoMapper::toDto)
                .orElseThrow(()->new RuntimeException("Transacao não encontrada"));
    }
    public TransacaoDto atualizarTransacao(Long id, TransacaoDto transacaoDto) {
        Transacao transacao = transacaoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Transação não encontrada"));
        transacao.setDescricao(transacaoDto.getDescricao());
        transacao.setValor(transacaoDto.getValor());
        transacao.setData(transacaoDto.getData());
        transacao.setTipoTransacao(transacaoDto.getTipoTransacao());

        Transacao transacaoAtualizada = transacaoRepository.save(transacao);
        return transacaoMapper.toDto(transacaoAtualizada);
    }

    public void deletar(Long id) {
        if(!transacaoRepository.existsById(id)) {
            throw new RuntimeException("Transação não encontrada");
        }
        transacaoRepository.deleteById(id);
    }
}
