package com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.novaCompra.Compra;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Objects;


@Entity
public class Transacao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long idTransacaoGateway;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusCompraTransacao status;

    @NotNull
    @ManyToOne
    private Compra compra;

    @NotNull
    private Instant momentoPagamento = Instant.now();

    @Deprecated
    public Transacao() {
    }

    public Transacao(Long idTransacaoGateway, StatusCompraTransacao status, Compra compra) {
        this.idTransacaoGateway = idTransacaoGateway;
        this.status = status;
        this.compra = compra;

    }


    public boolean concluidaComSucesso() {
        return this.status.equals(StatusCompraTransacao.SUCESSO);

    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransacaoGateway, status, compra, momentoPagamento);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return Objects.equals(idTransacaoGateway, transacao.idTransacaoGateway) && status == transacao.status && Objects.equals(compra, transacao.compra) && Objects.equals(momentoPagamento, transacao.momentoPagamento);
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", idTransacaoGateway=" + idTransacaoGateway +
                ", status=" + status +

                ", momentoPagamento=" + momentoPagamento +
                '}';
    }
}
