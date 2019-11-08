package model.Pagamento.Facade;

import model.Pagamento.Pagamento;

public class PagamentoPaypalFacade implements Pagamento {

    private PagamentoPaypal pagamentoPaypal;

    public PagamentoPaypalFacade(PagamentoPaypal pagamentoPaypal) {
        this.pagamentoPaypal = pagamentoPaypal;
    }

    public String pagar(){
        return pagamentoPaypal.pagar();
    }
}
