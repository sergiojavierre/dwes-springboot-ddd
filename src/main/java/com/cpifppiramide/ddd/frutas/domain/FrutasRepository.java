package com.cpifppiramide.ddd.frutas.domain;

import java.util.List;

public interface FrutasRepository {

    public List<Fruta> lista();
    public Fruta add(Fruta fruta);

}
