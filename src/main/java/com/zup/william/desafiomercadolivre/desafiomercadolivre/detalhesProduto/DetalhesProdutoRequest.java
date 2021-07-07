package com.zup.william.desafiomercadolivre.desafiomercadolivre.detalhesProduto;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.OpinoesAuxiliar;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public class DetalhesProdutoRequest {

    private String nome;
    //private Set<DetalhesFotoRequest> imagens;
    private Set<String> imagens;
    private BigDecimal preco;
    private String descricao;
    private double notaMedia;
    private long totalNotas;
    private Set<DetalhesCaracteristica> caracteristicas;
    private Set<Map<String, String>> opinioes;
    private Set<PerguntaRequest> perguntas;

    public String getNome() {
        return nome;
    }

    public Set<String> getImagens() {
        return imagens;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public long getTotalNotas() {
        return totalNotas;
    }

    public Set<DetalhesCaracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public Set<Map<String, String>> getOpinioes() {
        return opinioes;
    }

    public Set<PerguntaRequest> getPerguntas() {
        return perguntas;
    }

    public DetalhesProdutoRequest(Produto produto, EntityManager manager) {
        this.nome = produto.getNome();
        this.preco = produto.getValor();
        this.descricao = produto.getDescricao();

        this.caracteristicas = produto.mapeiaCaracteristicas(DetalhesCaracteristica::new);  //passanbdo por DTO

        this.imagens = produto.mapeiaImagens(foto -> foto.getLink()); //Passando por String

        this.perguntas = produto.mapeiaPerguntas(PerguntaRequest::new);

        OpinoesAuxiliar opinioesAux = produto.getOpinioes();
        this.opinioes = opinioesAux.mapeiaOpinioes(opiniao -> {  //passando por Map customizado
            return Map.of("Titulo: ", opiniao.getOpiniao().toString(), "Descrição: ", opiniao.getDescricao());
        });
        this.notaMedia = opinioesAux.media();
        this.totalNotas = opinioesAux.totalOpinioes();


    }

    @Deprecated
    public DetalhesProdutoRequest() {
    }


}
