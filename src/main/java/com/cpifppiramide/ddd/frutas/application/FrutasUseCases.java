package com.cpifppiramide.ddd.frutas.application;

import com.cpifppiramide.ddd.frutas.domain.Fruta;
import com.cpifppiramide.ddd.frutas.domain.FrutasRepository;

import java.util.List;

public class FrutasUseCases {

    private final FrutasRepository frutasRepository;

    public FrutasUseCases(FrutasRepository frutasRepository){
        this.frutasRepository = frutasRepository;
    }

    public List<Fruta> lista(){
        return this.frutasRepository.lista();
    }

    public Fruta add(Fruta fruta){
        return this.frutasRepository.add(fruta);
    }
}
