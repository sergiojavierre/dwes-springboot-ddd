package com.cpifppiramide.ddd.usuarios.domain;

public interface UsuarioRepository {

    public void registro(Usuario usuario);
    public Usuario login(String alias, String password);
}