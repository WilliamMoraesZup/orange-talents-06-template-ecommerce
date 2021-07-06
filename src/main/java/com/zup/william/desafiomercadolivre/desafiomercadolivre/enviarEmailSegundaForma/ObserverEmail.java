package com.zup.william.desafiomercadolivre.desafiomercadolivre.enviarEmailSegundaForma;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ObserverEmail {

    public List<ListenerPergunta> listeners = new ArrayList<>();

    public void addListener(ListenerPergunta listenerPergunta) {
        listeners.add(listenerPergunta);

    }

    public void notificaObservers() {
        for (ListenerPergunta pl : listeners) {
         //  pl.alguemPerguntou();
        }
    }


}
