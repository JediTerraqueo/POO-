package restaurante;

public class Prato {
    private static int contador = 1;
    private int numero;
    private String nome;
    private String descricao;
    private double preco;

    public Prato(String nome, String descricao, double preco) {
        this.numero = contador;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        contador++;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }
}
