package model.Pagamento.Cartao;

public class Credito extends Cartao {

    public Credito() {
        this.tipo = "credito";
    }

    @Override
    public String pagar() {
        return "Pago com crédito";
    }
}
