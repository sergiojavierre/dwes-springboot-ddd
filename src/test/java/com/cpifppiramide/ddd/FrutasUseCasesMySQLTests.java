package com.cpifppiramide.ddd;

import com.cpifppiramide.ddd.context.DBConnection;
import com.cpifppiramide.ddd.frutas.application.FrutasUseCases;
import com.cpifppiramide.ddd.frutas.domain.Fruta;
import com.cpifppiramide.ddd.frutas.infrastructure.FrutasRepositoryMySQL;
import com.cpifppiramide.ddd.supermercados.domain.Supermercado;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrutasUseCasesMySQLTests {

    private FrutasUseCases frutasUseCases;

    public FrutasUseCasesMySQLTests(){
        this.frutasUseCases = new FrutasUseCases(new FrutasRepositoryMySQL());
    }

    @BeforeEach
    void populate(){
        try {
            DBConnection.getInstance().prepareStatement(
                    "insert into frutas values ('Banana', 1, 2.04)"
            ).execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    void clean(){
        try {
            DBConnection.getInstance().prepareStatement(
                    "delete from frutas"
            ).execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void lista(){
        List<Fruta> frutas = this.frutasUseCases.lista();
        assertEquals(1, frutas.size());
    }

    @Test
    void add(){
        Fruta fruta = new Fruta("Papaya", new Supermercado(1), 2.50f);
        Fruta frutaCreada = this.frutasUseCases.add(fruta);
        assertEquals(fruta, frutaCreada);
        List<Fruta> frutas = this.frutasUseCases.lista();
        assertEquals(2,frutas.size());
    }

    @Test
    void addRepetido(){
        Fruta fruta = new Fruta("Banana", new Supermercado(1), 2.50f);
        Fruta frutaCreada = this.frutasUseCases.add(fruta);
        assertEquals(null, frutaCreada);
        List<Fruta> frutas = this.frutasUseCases.lista();
        assertEquals(1,frutas.size());
    }

}
