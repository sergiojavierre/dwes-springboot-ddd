package com.cpifppiramide.ddd.usuarios.infrastructure.web;

import com.cpifppiramide.ddd.usuarios.application.UsuarioUseCases;
import com.cpifppiramide.ddd.usuarios.domain.Usuario;
import com.cpifppiramide.ddd.usuarios.domain.UsuarioRepository;
import com.cpifppiramide.ddd.usuarios.infrastructure.data.mysql.UsuarioRepositoryMySQL;
import com.cpifppiramide.ddd.usuarios.infrastructure.data.ram.UsuarioRepositoryRAM;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    UsuarioRepository usuarioRepository ;
    UsuarioUseCases usuarioUseCases;

    public UsuarioController(){
        this.usuarioRepository = new UsuarioRepositoryMySQL();
        this.usuarioUseCases = new UsuarioUseCases(usuarioRepository);
    }

    @GetMapping("/")
    public String index(){

        Usuario usuario = new Usuario("demo", "abc");
        this.usuarioUseCases.registro(usuario);

        return "index";
    }

    @GetMapping("/login")
    public String login(){

        String alias = "demo";
        String password = "123";
        Usuario usuario = this.usuarioUseCases.login(new Usuario(alias,password));
        System.out.println(usuario);
        return "index";
    }



}
