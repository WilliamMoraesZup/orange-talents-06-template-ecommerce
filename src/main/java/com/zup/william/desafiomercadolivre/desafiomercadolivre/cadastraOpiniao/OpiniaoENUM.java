package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraOpiniao;

import java.util.Arrays;

public enum OpiniaoENUM {
    HORRIVEL(1), RUIM(2), NEUTRO(3), BOM(4), PERFEITO(5);


    private int nota;

    OpiniaoENUM(int nota) {
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }

    public static OpiniaoENUM pegaOpiniaoPorValor(int nota) {
        OpiniaoENUM opiniaoPorNota = Arrays.stream(OpiniaoENUM.values()).filter(e -> e.getNota() == nota).findFirst().get();

        return opiniaoPorNota;
    }
}
