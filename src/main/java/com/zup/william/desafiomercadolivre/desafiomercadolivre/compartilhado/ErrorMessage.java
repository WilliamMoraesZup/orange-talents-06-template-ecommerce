package com.zup.william.desafiomercadolivre.desafiomercadolivre.compartilhado;

public class ErrorMessage {
    private String field;
    private String description;

    private String mensagem;

    public ErrorMessage(String field, String description, String mensagem) {
        this.field = field;
        this.description = description;
        this.mensagem = mensagem;
    }

    public String getField() {
        return field;
    }

    public String getDescription() {
        return description;
    }

    public String getMensagem() {
        return mensagem;
    }
}
