package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Carrinho extends Observable {

    private Observer view;
    private List<Produto> produtos;
    private static Carrinho carrinho;
    private Pagamento meioDePagamento;

    public Pagamento getMeioDePagamento() {
        return meioDePagamento;
    }

    public void setMeioDePagamento(Pagamento meioDePagamento) {
        this.meioDePagamento = meioDePagamento;
    }


    private Carrinho() {
        this.produtos = new ArrayList<Produto>();
    }

    public void adicionaProduto(Produto produto) {
        produtos.add(produto);
        view.update(this, "add");
    }

    public void removeProduto(Produto produto) {
        produtos.remove(produto);
        view.update(this, "del");
    }

    public void registra(Observer obs) {
        view = obs;
    }

    public Observer getView() {
        return view;
    }

    public void setView(Observer view) {
        this.view = view;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public static Carrinho getInstance() {
        if (carrinho == null)
            carrinho = new Carrinho();
        return carrinho;
    }
}
