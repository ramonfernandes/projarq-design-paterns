package controller;

import model.Produtos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    List<Produtos> produtos;

    public Controller() {
        this.produtos = new ArrayList<Produtos>();
    }

    public String listarProdutos() {
        String result = "LISTA DE ITENS \n\n";
        for (Produtos produto : produtos) {
            result += "ID: " + produto.getId() + "----- Nome:" + produto.getNome() + "\n";
        }
        return result;
    }

    public void createItem(String nome) {
        produtos.add(new Produtos(nome));
    }

    public List<Produtos> getProduto(Integer op) {
        return produtos.stream()
                .filter(produto -> produto.getId() == op)
                .collect(Collectors.toList());
    }

    public void addProdutos(List<Produtos> produto) {
        produtos.addAll(produto);
    }

    public void removeProdutos(List<Produtos> produto) {
        produtos.removeAll(produto);
    }
}
