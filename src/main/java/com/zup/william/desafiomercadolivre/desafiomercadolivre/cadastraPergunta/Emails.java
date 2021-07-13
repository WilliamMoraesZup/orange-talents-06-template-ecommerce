package com.zup.william.desafiomercadolivre.desafiomercadolivre.cadastraPergunta;

import com.zup.william.desafiomercadolivre.desafiomercadolivre.novaCompra.Compra;
import com.zup.william.desafiomercadolivre.desafiomercadolivre.retornoCompra.sistemasExternos.EventoCompraBemSucedida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
public class Emails implements EventoCompraBemSucedida {

    @Autowired
    private Mailer mailer;

    public void novaPergunta(@NotNull @Valid Pergunta pergunta) {

        mailer.send("<html><body>Emails enviado</body><html>",
                "NovaPergunta...",
                pergunta.getPerguntador().getLogin(),
                "vendas@zup.com.ml",
                pergunta.getDonoProduto());

    }

    public void novaCompra(@NotNull @Valid Compra compra) {
        mailer.send("<html><body>Emails enviado</body><html>",
                "Uma nova compra foi realizada.\nProduto" + compra.getProdutoEscolhido().getNome(),
                compra.getComprador().getLogin(),
                "site ZupLivre.com ",
                compra.getProdutoEscolhido().getUsuarioVendedor().getLogin());
    }

    public void processa(@NotNull @Valid Compra compra) {
        mailer.send("<html><body>Emails enviado</body><html>",
                "Sua compra foi faturada com sucesso: " + compra.getProdutoEscolhido().getNome(),
                compra.getComprador().getLogin(),
                "site ZupLivre.com ",
                compra.getProdutoEscolhido().getUsuarioVendedor().getLogin());
    }

}
