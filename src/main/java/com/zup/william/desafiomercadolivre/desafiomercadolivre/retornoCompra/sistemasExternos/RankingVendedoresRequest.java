package com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra.sistemasExternos;

import javax.validation.constraints.NotNull;

public class RankingVendedoresRequest {
    @NotNull
    private Long idVendedor;
    @NotNull
    private Long idCompra;

    public RankingVendedoresRequest(Long idVendedor, Long idCompra) {
        this.idVendedor = idVendedor;
        this.idCompra = idCompra;
    }

    @Override
    public String toString() {
        return "RankingVendedoresRequest{" +
                "idVendedor=" + idVendedor +
                ", idCompra=" + idCompra +
                '}';
    }
}
