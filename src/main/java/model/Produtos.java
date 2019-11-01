package model;

public class Produtos {

    private static int idAux = 0;
    private int id;
    private String nome;

    public Produtos(String nome) {
        this.id = idAux;
        this.nome = nome;
        idAux++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
