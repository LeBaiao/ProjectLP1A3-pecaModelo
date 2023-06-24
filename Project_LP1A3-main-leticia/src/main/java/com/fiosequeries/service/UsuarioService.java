package com.fiosequeries.service;

import com.fiosequeries.Model.Usuario;
import com.fiosequeries.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarUsuario(Long id){
        Usuario usuario = new Usuario();
        usuario = usuarioRepository.findById(id).orElse(null);
        return usuario;
    }
}
