package com.zup.william.desafiomercadolivre.desafiomercadolivre.detalhesProduto;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraPergunta.Pergunta;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;

public class PerguntaRequest implements Comparable<PerguntaRequest> {


    @NotBlank
    private String titulo;

    public PerguntaRequest(Pergunta pergunta) {

        this.titulo = pergunta.getTitulo();
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public int compareTo(@NotNull PerguntaRequest o) {
        return this.titulo.compareTo(o.titulo);
    }
}
