package com.cpifppiramide.ddd.usuarios.infrastructure.data.ram;

import com.cpifppiramide.ddd.usuarios.domain.Usuario;
import com.cpifppiramide.ddd.usuarios.domain.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepositoryRAM implements UsuarioRepository {

    private List<Usuario> usuarios;

    public UsuarioRepositoryRAM() {
        this.usuarios = new ArrayList<>();
    }

    @Override
    public void registro(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    @Override
    public Usuario login(String alias, String password) {
        Optional<Usuario> opt = this.usuarios.stream().filter(usuario -> usuario.getAlias().equals(alias) && usuario.getPassword().equals(password)).findFirst();
        return opt.orElse(null);
    }
}
