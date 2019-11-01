package model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<Produtos> produtos;
    private static Carrinho carrinho;

    private Carrinho() {
        this.produtos = new ArrayList<Produtos>();
    }

    public Carrinho getInstance() {
        if (carrinho == null)
            carrinho = new Carrinho();
        return carrinho;
    }
}
