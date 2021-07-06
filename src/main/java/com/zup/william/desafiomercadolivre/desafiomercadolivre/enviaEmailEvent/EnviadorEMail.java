package com.zup.william.desafiomercadolivre.desafiomercadolivre.enviaEmailEvent;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraPergunta.Pergunta;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroUsuario.Usuario;

public class EnviadorEMail {

    public void enviarEmail(Usuario usuario, Pergunta pergunta) {
        System.out.println("ENVIADOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        System.out.println("Emais enviado com sucesso para " + usuario.getLogin() + " referente a pergunta " + pergunta.getTitulo());
    }
}
