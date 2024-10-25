package com.cpifppiramide.ddd.usuarios.domain;

public class Usuario {

    private final String alias, password;

    public Usuario(String alias, String password) {
        this.alias = alias;
        this.password = password;
    }

    public String getAlias() {
        return alias;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "alias='" + alias + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
