package com.zup.william.desafiomercadolivre.desafiomercadolivre.compartilhado;

public class ErrorMessage {
    private String campo;
    private String valor;

    private String mensagem;

    public ErrorMessage(String campo, String valor, String mensagem) {
        this.campo = campo;
        this.valor = valor;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getValor() {
        return valor;
    }

    public String getMensagem() {
        return mensagem;
    }
}
