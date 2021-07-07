package com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoParaFront;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraOpiniao.Opiniao;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraPergunta.Pergunta;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Produto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoFrontRequest {

    private String nome;
    private List<FotoProdutoRequest> imagens;
    private BigDecimal preco;
    private String descricao;
    private long notaMedia;
    private long totalNotas;
    private List<CaracteristicaRequest> caracteristicas;
    private List<OpiniaoRequest> opinioes;
    private List<PerguntaRequest> perguntas;

    public String getNome() {
        return nome;
    }

    public List<FotoProdutoRequest> getImagens() {
        return imagens;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public long getNotaMedia() {
        return notaMedia;
    }

    public long getTotalNotas() {
        return totalNotas;
    }

    public List<CaracteristicaRequest> getCaracteristicas() {
        return caracteristicas;
    }

    public List<OpiniaoRequest> getOpinioes() {
        return opinioes;
    }

    public List<PerguntaRequest> getPerguntas() {
        return perguntas;
    }

    public ProdutoFrontRequest(Produto produto, EntityManager manager) {
        this.nome = produto.getNome();
        this.preco = produto.getValor();
        this.descricao = produto.getDescricao();
        this.imagens = produto.getImagens().stream().map(FotoProdutoRequest::new).collect(Collectors.toList());
        this.caracteristicas = produto.getCaracteristicasList().stream().map(CaracteristicaRequest::new).collect(Collectors.toList());

        Query queryOpiniao = manager.createQuery("from Opiniao where produto.id = :pValue");
        queryOpiniao.setParameter("pValue", produto.getId());
        List<Opiniao> resultList = queryOpiniao.getResultList();
        this.opinioes = resultList.stream().map(OpiniaoRequest::new).collect(Collectors.toList());

        long qtdeOpinioes = this.opinioes.size();
        Integer somaOpinioes = this.opinioes.stream().map(opiniaoRequest -> opiniaoRequest.getOpiniao().getNota()).reduce(Integer::sum).get();

        this.notaMedia = (long) somaOpinioes / qtdeOpinioes;
        this.totalNotas = qtdeOpinioes;

        Query queryPergunta = manager.createQuery("from Pergunta where produto.id = :pValue");
        queryPergunta.setParameter("pValue", produto.getId());
        List<Pergunta> resultListPergunta = queryPergunta.getResultList();
        this.perguntas = resultListPergunta.stream().map(PerguntaRequest::new).collect(Collectors.toList());

    }

    @Deprecated
    public ProdutoFrontRequest() {
    }

    @Override
    public String toString() {
        return "ProdutoFrontRequest{" +
                "nome='" + nome + '\'' +
                ", imagens=" + imagens +
                ", preco=" + preco +
                ", descricao='" + descricao + '\'' +
                ", Média de Notas=" + notaMedia +
                ", Total de Notas=" + totalNotas +
                ", caracteristicas=" + caracteristicas +
                ", opinioes=" + opinioes +
                ", perguntas=" + perguntas +
                '}';
    }
}
