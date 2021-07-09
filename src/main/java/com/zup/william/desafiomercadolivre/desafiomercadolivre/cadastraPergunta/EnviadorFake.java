package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraPergunta;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EnviadorFake implements Mailer {
    @Override
    public void send(String body, String assunto, String nomeDeQuemPergunta, String from, String emailDeQuemVaiResponder) {
        System.out.println(body);
        System.out.println(assunto);
        System.out.println(nomeDeQuemPergunta);
        System.out.println(from);
        System.out.println(emailDeQuemVaiResponder);
    }
}
