package com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoParaFront;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraPergunta.Pergunta;

import javax.validation.constraints.NotBlank;

public class PerguntaRequest {


    @NotBlank
    private String titulo;

    public PerguntaRequest(Pergunta pergunta) {

        this.titulo = pergunta.getTitulo();
    }

    public String getTitulo() {
        return titulo;
    }
}
