package com.example.gastos_pessoais.mappers;

import com.example.gastos_pessoais.dtos.UsuarioDto;
import com.example.gastos_pessoais.models.Usuario;

public class UsuarioMapper {

    public UsuarioDto toDto(Usuario usuario) {
        if(usuario==null) {
            return null;
        }
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNome(usuario.getNome());
        return usuarioDto;
    }
    public Usuario toEntity(UsuarioDto usuarioDto) {
        if(usuarioDto==null) {
            return  null;
        }
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDto.getNome());
        return usuario;
    }
}
