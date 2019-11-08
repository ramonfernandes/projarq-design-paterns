package model.Pagamento.Cartao;

public class Debito extends Cartao {

    public Debito() {
        this.tipo = "debito";
    }

    @Override
    public String pagar() {
        return "Pago com débito";
    }
}
