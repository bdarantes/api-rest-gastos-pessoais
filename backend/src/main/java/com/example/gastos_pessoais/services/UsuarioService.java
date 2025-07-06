package com.example.gastos_pessoais.services;

import com.example.gastos_pessoais.dtos.UsuarioDto;
import com.example.gastos_pessoais.exceptions.RecursoNaoEncontradoException;
import com.example.gastos_pessoais.mappers.UsuarioMapper;
import com.example.gastos_pessoais.models.Usuario;
import com.example.gastos_pessoais.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository =usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioDto salvarUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDto);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuarioSalvo);
    }
    public List<UsuarioDto>listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }
    public UsuarioDto buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toDto)
                .orElseThrow(()->new RecursoNaoEncontradoException("Usuario não encontrado"));
    }
    public UsuarioDto atualizarUsuario(Long id, UsuarioDto usuarioDto) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(()-> new RecursoNaoEncontradoException("Usuario não encontrado"));
        usuarioExistente.setNome(usuarioDto.getNome());
        Usuario usuarioAtualizado= usuarioRepository.save(usuarioExistente);
        return usuarioMapper.toDto(usuarioAtualizado);
    }

    public void deletar(Long id) {
        if(!usuarioRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Usuario não encontrado");
        }
        usuarioRepository.deleteById(id);

    }

}
