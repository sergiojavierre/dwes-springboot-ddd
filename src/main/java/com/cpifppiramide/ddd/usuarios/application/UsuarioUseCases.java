package com.cpifppiramide.ddd.usuarios.application;

import com.cpifppiramide.ddd.usuarios.domain.Usuario;
import com.cpifppiramide.ddd.usuarios.domain.UsuarioRepository;

public class UsuarioUseCases {

    private final UsuarioRepository usuarioRepository;

    public UsuarioUseCases(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void registro(Usuario usuario){
        String cifrada = usuario.getPassword().toUpperCase();
        Usuario aGuardar = new Usuario(usuario.getAlias(), cifrada);
        this.usuarioRepository.registro(aGuardar);
    }

    public Usuario login(String alias, String password){
        String cifrada = password.toUpperCase();
        return this.usuarioRepository.login(alias, cifrada);
    }
}
