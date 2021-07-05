package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto;

public class CaracteristicaForm {


    private String nome;
    private String descricao;

    public CaracteristicaForm(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Caracteristica toModel() {
        return
                new Caracteristica(nome, descricao);

    }

    @Override
    public String toString() {
        return "CaracteristicaForm{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
