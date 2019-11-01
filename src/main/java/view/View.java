package view;

import controller.Controller;
import model.Produtos;

import java.util.Scanner;

public class View {

    Controller controller = new Controller();
    Scanner scan = new Scanner(System.in);

    public void menu() {
        System.out.println("0 - Criar produto " +
                "\n 1 - Adicionar ao carrinho " +
                "\n 2 - Remover do carrinho " +
                "\n 3 - Listar produtos");
        Integer op = scan.nextInt();

        switch(op) {
            case 0:
                criarProduto();
                break;
            case 1:
                adicionarCarrinho();
                break;
            case 2:
                removerCarrinho();
                break;
            case 3:
                listarProdutos();
                break;
        }
    }

    private void removerCarrinho() {
        System.out.println("Selecione o produto");
        Integer op = scan.nextInt();
        controller.removeProdutos(controller.getProduto(op));
    }

    private void listarProdutos() {
        System.out.println(controller.listarProdutos());
    }

    private void adicionarCarrinho() {
        System.out.println("Selecione o produto");
        Integer op = scan.nextInt();
        controller.addProdutos(controller.getProduto(op));
    }

    private void criarProduto() {
        System.out.println("Digite o nome do produto");
        String nome = scan.next();
        controller.createItem(nome);
    }

}
