package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto;

import java.util.Objects;

public class CaracteristicaForm {


    private String nome;
    private String descricao;

    public CaracteristicaForm(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Caracteristica toModel() {

        System.out.println(nome);
        System.out.println(descricao);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaracteristicaForm that = (CaracteristicaForm) o;
        return Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao);
    }
}
