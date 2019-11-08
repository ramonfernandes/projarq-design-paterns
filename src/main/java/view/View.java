package view;

import controller.Controller;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class View implements Observer {

    Controller controller = new Controller(this);
    Scanner scan = new Scanner(System.in);

    public void menu() {
        System.out.println("0 - Criar produto " +
                "\n 1 - Adicionar ao carrinho " +
                "\n 2 - Remover do carrinho " +
                "\n 3 - Listar produtos" +
                "\n 4 - Listar carrinho" +
                "\n 5 - Adicionar método de pagamento" +
                "\n 6 - Pagar");

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
            case 4:
                listarCarrinho();
                break;
            case 5:
                definirMetodoDePagamento();
                break;
            case 6:
                System.out.println(controller.pagar());
        }
    }

    private void definirMetodoDePagamento() {
        System.out.println(
                "\n 0 - Cartão de Débito " +
                "\n 1 - Cartão de Crédito " +
                "\n 2 - Boleto" +
                "\n 3 - Paypal");

        Integer op = scan.nextInt();

        switch(op) {
            case 0:
                controller.pagarComDebito();
                break;
            case 1:
                controller.pagarComCredito();
                break;
            case 2:
            case 3:
        }
    }

    private void listarCarrinho() {
        System.out.println(controller.listarCarrinho());
    }

    private void removerCarrinho() {
        System.out.println("Selecione o produto");
        Integer op = scan.nextInt();
        controller.removeProdutos(controller.getProduto(op).get(0));
    }

    private void listarProdutos() {
        System.out.println(controller.listarProdutos());
    }

    private void adicionarCarrinho() {
        System.out.println("Selecione o produto");
        Integer op = scan.nextInt();
        controller.addProdutos(controller.getProduto(op).get(0));
    }

    private void criarProduto() {
        System.out.println("Digite o nome do produto");
        String nome = scan.next();
        controller.createItem(nome);
    }

    @Override
    public void update(Observable o, Object arg) {
        String option = (String) arg;
        if(option.equals("add"))
            System.out.println("Produto adicionado");
        if(option.equals("del"))
            System.out.println("Produto removido");
    }
}
