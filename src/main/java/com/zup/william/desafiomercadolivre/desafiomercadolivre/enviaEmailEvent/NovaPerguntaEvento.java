package com.zup.william.desafiomercadolivre.desafiomercadolivre.enviaEmailEvent;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraPergunta.Pergunta;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;
import org.springframework.context.ApplicationEvent;

public class NovaPerguntaEvento extends ApplicationEvent {

    private final Pergunta pergunta;
    private final Usuario usuario;

    public NovaPerguntaEvento(Object source, Pergunta pergunta, Usuario usuario) {
        super(source);
        this.pergunta = pergunta;
        this.usuario = usuario;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
