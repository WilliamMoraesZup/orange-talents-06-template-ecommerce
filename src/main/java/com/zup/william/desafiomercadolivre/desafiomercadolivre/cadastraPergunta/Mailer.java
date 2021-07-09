package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraPergunta;

import javax.validation.constraints.NotBlank;

public interface Mailer {

    /**
     * @param body               corpo do email
     * @param assunto
     * @param nomeDeQuemPergunta
     * @param from               site de origem
     * @param quemVaiResponser
     */
    void send(@NotBlank String body, @NotBlank String assunto, @NotBlank String nomeDeQuemPergunta, @NotBlank String from, @NotBlank String quemVaiResponser);

}
