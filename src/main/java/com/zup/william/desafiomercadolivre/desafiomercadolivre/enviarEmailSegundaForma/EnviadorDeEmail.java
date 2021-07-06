package com.zup.william.desafiomercadolivre.desafiomercadolivre.enviarEmailSegundaForma;

public class EnviadorDeEmail implements ListenerPergunta {



    @Override
    public void alguemPerguntou(String email) {
        System.out.println("enviando email para " + email);

    }
}
