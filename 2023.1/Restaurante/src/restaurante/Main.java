package restaurante;

public class Main {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();

        Prato prato1 = new Prato("Arroz, feijão e frango", "Arroz, feijão e frango grelhado", 25.0);
        Prato prato2 = new Prato("Pizza", "Pizza de mussarela com tomate", 35.0);
        Prato prato3 = new Prato("Hambúrguer", "Hambúrguer com queijo, alface e tomate", 20.0);

        restaurante.adicionarPrato(prato1);
        restaurante.adicionarPrato(prato2);
        restaurante.adicionarPrato(prato3);

        restaurante.fazerPedido(prato1, 2, 1);
        restaurante.fazerPedido(prato2, 1, 2);
        restaurante.fazerPedido(prato3, 3, 1);

        restaurante.imprimirCardapio();
        restaurante.imprimirPedidos();
    }
}
