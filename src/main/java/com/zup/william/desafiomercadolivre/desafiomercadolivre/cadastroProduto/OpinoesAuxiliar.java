package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraOpiniao.Opiniao;

import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * Auxiliar para realizar calculos de opinoes
 */
public class OpinoesAuxiliar {

    private Set<Opiniao> opinioes;


    public OpinoesAuxiliar(Set<Opiniao> opinioes) {
        this.opinioes = opinioes;
    }

    public <T> Set<T> mapeiaOpinioes(Function<Opiniao, T> funcaoMapeadora) {

        return this.opinioes.stream()
                .map(funcaoMapeadora)
                .collect(Collectors.toSet());
    }


    public double media() {
        OptionalDouble average = opinioes.stream().map(opiniao -> opiniao.getOpiniao().getNota()).mapToInt(e -> e).average();
        return average.orElse(0.0);
    }

    public int totalOpinioes() {
        return opinioes.size();
    }
}
