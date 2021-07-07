package com.zup.william.desafiomercadolivre.desafiomercadolivre.detalhesProduto;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastroProduto.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Map;
import java.util.OptionalDouble;
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
        this.caracteristicas = produto.mapeiaCaracteristicas(DetalhesCaracteristica::new);  //´passanbdo por DTO
        this.imagens = produto.mapeiaImagens(foto -> foto.getLink()); //Passando por String
        this.perguntas = produto.mapeiaPerguntas(PerguntaRequest::new);
        this.opinioes = produto.mapeiaOpinioes(opiniao -> {  //passando por Map customizado
            return Map.of("Titulo: ", opiniao.getOpiniao().toString(), "Descrição: ", opiniao.getDescricao());
        });

//  USANDO MAP TO INT E AVERAGE
        OptionalDouble average = produto.mapeiaOpinioes(opiniao -> opiniao.getOpiniao().getNota()).stream().mapToInt(e -> e).average();
        this.notaMedia = average.orElseGet(() -> 0.0);

        // this.imagens = produto.getImagens().stream().map(FotoProdutoRequest::new).collect(Collectors.toList());
        //this.caracteristicas = produto.getCaracteristicasList().stream().map(DetalhesCaracteristica::new).collect(Collectors.toList());
//        Query queryOpiniao = manager.createQuery("from Opiniao where produto.id = :pValue");
//        queryOpiniao.setParameter("pValue", produto.getId());
//        List<Opiniao> resultList = queryOpiniao.getResultList();
//        this.opinioes = resultList.stream().map(OpiniaoRequest::new).collect(Collectors.toList());


        //  Integer somaOpinioes = this.opinioes.stream().map(opiniaoRequest -> opiniaoRequest.getOpiniao().getNota()).reduce(Integer::sum).get();


//        Query queryPergunta = manager.createQuery("from Pergunta where produto.id = :pValue");
//        queryPergunta.setParameter("pValue", produto.getId());
//        List<Pergunta> resultListPergunta = queryPergunta.getResultList();
//       // this.perguntas = resultListPergunta.stream().map(PerguntaRequest::new).collect(Collectors.toList());

    }

    @Deprecated
    public DetalhesProdutoRequest() {
    }


}
