package com.example.gastos_pessoais.mappers;

import com.example.gastos_pessoais.dtos.TransacaoDto;
import com.example.gastos_pessoais.models.Transacao;
import org.springframework.stereotype.Component;

@Component
public class TransacaoMapper {

    public TransacaoDto toDto(Transacao transacao) {
        if(transacao==null) {
            return null;
        }
        TransacaoDto transacaoDto = new TransacaoDto();
        transacaoDto.setDescricao(transacao.getDescricao());
        transacaoDto.setValor(transacao.getValor());
        transacaoDto.setData(transacao.getData());
        transacaoDto.setTipoTransacao(transacao.getTipoTransacao());
        return transacaoDto;
    }
    public Transacao toEntity(TransacaoDto transacaoDto) {
        if(transacaoDto ==null) {
            return null;
        }
        Transacao transacao = new Transacao();
        transacao.setDescricao(transacaoDto.getDescricao());
        transacao.setValor(transacaoDto.getValor());
        transacao.setData(transacaoDto.getData());
        transacao.setTipoTransacao(transacaoDto.getTipoTransacao());
        return transacao;
    }
}
