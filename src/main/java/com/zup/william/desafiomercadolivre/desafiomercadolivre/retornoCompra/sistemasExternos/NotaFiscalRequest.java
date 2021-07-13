package com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra.sistemasExternos;

import javax.validation.constraints.NotNull;

public class NotaFiscalRequest  {
    @NotNull
    private Long idCompra;
    @NotNull
    private Long idComprador;

    public NotaFiscalRequest(Long idCompra, Long idComprador) {
        this.idCompra = idCompra;
        this.idComprador = idComprador;
    }

    @Override
    public String toString() {
        return "NotaFiscalRequest{" +
                "idCompra=" + idCompra +
                ", IdComprador=" + idComprador +
                '}';
    }
}
