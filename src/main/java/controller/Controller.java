package controller;

import model.*;
import model.Pagamento.Cartao.Credito;
import model.Pagamento.Cartao.Debito;
import model.Pagamento.Facade.PagamentoBoleto;
import model.Pagamento.Facade.PagamentoBoletoFacade;
import model.Pagamento.Facade.PagamentoPaypal;
import model.Pagamento.Facade.PagamentoPaypalFacade;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.stream.Collectors;

public class Controller {

    Carrinho carrinho;
    List<Produto> produtos;

    public Controller(Observer obs) {
        this.carrinho = Carrinho.getInstance();
        this.produtos = new ArrayList<>();
        carrinho.registra(obs);
    }

    public String listarProdutos() {
        String result = "LISTA DE ITENS \n\n";
        for (Produto produto : produtos) {
            result += "ID: " + produto.getId() + "----- Nome:" + produto.getNome() + "\n";
        }
        return result;
    }

    public void createItem(String nome) {
        produtos.add(new Produto(nome));
    }

    public List<Produto> getProduto(Integer op) {
        return produtos.stream()
                .filter(produto -> produto.getId() == op)
                .collect(Collectors.toList());
    }

    public void addProdutos(Produto produto) {
        carrinho.adicionaProduto(produto);
    }

    public void removeProdutos(Produto produto) {
        carrinho.removeProduto(produto);
    }

    public String listarCarrinho() {
        String result = "CARRINHO \n\n";
        for (Produto produto : carrinho.getProdutos()) {
            result += "ID: " + produto.getId() + "----- Nome:" + produto.getNome() + "\n";
        }
        return result;
    }

    public void pagarComDebito() {
        carrinho.setMeioDePagamento(new Debito());
    }

    public void pagarComCredito() {
        carrinho.setMeioDePagamento(new Credito());
    }

    public void pagarComPaypal() {
        carrinho.setMeioDePagamento(new PagamentoPaypalFacade(new PagamentoPaypal()));
    }

    public void pagarComBoleto() {
        carrinho.setMeioDePagamento(new PagamentoBoletoFacade(new PagamentoBoleto()));
    }

    public String pagar() {
        if (carrinho.getMeioDePagamento() != null)
            return carrinho.getMeioDePagamento().pagar();
        return "Meio de Pagamento não especificado";
    }
}
