package com.cpifppiramide.ddd.usuarios.infrastructure.data.mysql;

import com.cpifppiramide.ddd.context.DBConnection;
import com.cpifppiramide.ddd.usuarios.domain.Usuario;
import com.cpifppiramide.ddd.usuarios.domain.UsuarioRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRepositoryMySQL implements UsuarioRepository {
    @Override
    public void registro(Usuario usuario) {
        try {
            String sql = "insert into usuarios values (?,?)";
            PreparedStatement statement = DBConnection.getInstance().prepareStatement(sql);
            statement.setString(1,usuario.getAlias());
            statement.setString(2,usuario.getPassword());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Usuario login(String alias, String password) {
        try {
            String sql = "select * from usuarios where alias = ? and password = ?";
            PreparedStatement statement = DBConnection.getInstance().prepareStatement(sql);
            statement.setString(1, alias);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            rs.next();
            Usuario usuario = new Usuario(rs.getString("alias"), rs.getString("password"));
            return usuario;
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            return null;
        }
    }
}
