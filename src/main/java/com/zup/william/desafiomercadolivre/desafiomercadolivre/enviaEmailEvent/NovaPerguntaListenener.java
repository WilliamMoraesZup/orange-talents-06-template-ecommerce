package com.zup.william.desafiomercadolivre.desafiomercadolivre.enviaEmailEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

public class NovaPerguntaListenener implements ApplicationListener<NovaPerguntaEvento>, Ordered {

    @Autowired
    private EnviadorEMail enviador;

    public NovaPerguntaListenener(EnviadorEMail enviador) {
        this.enviador = enviador;
    }

    @Override
    public void onApplicationEvent(NovaPerguntaEvento event) {


        System.out.println("ENVIADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        enviador.enviarEmail(event.getUsuario(), event.getPergunta());

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
