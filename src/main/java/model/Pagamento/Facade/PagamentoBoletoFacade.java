package model.Pagamento.Facade;

import model.Pagamento.Pagamento;

public class PagamentoBoletoFacade implements Pagamento {
    private PagamentoBoleto pagamentoBoleto;

    public PagamentoBoletoFacade(PagamentoBoleto pagamentoBoleto) {
        this.pagamentoBoleto = pagamentoBoleto;
    }

    public String pagar(){
        return pagamentoBoleto.pagar();
    }
}
