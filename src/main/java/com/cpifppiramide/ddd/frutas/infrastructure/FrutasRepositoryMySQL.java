package com.cpifppiramide.ddd.frutas.infrastructure;

import com.cpifppiramide.ddd.context.DBConnection;
import com.cpifppiramide.ddd.frutas.domain.Fruta;
import com.cpifppiramide.ddd.frutas.domain.FrutasRepository;
import com.cpifppiramide.ddd.supermercados.domain.Supermercado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FrutasRepositoryMySQL implements FrutasRepository {
    @Override
    public List<Fruta> lista() {
        List<Fruta> frutas = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getInstance().prepareStatement("select * from frutas").executeQuery();
            while (rs.next()){
                Supermercado supermercado = new Supermercado(rs.getInt("supermercado"));
                Fruta fruta = new Fruta(rs.getString("nombre"), supermercado, rs.getFloat("precio"));
                frutas.add(fruta);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return frutas;
    }

    @Override
    public Fruta add(Fruta fruta) {
        try {
            DBConnection.getInstance().prepareStatement(
                    "insert into frutas " +
                            "values (" +
                            "'"+fruta.getNombre()+"'," +
                            ""+fruta.getSupermercado().getId()+"," +
                            ""+fruta.getPrecio()+
                            ")").execute();
        } catch (SQLException e) {
            return null;
        }
        return fruta;
    }


}
