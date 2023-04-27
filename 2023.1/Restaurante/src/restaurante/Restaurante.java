package restaurante;

import java.util.ArrayList;

public class Restaurante {
    private ArrayList<Prato> cardapio;
    private ArrayList<Pedido> pedidos;

    public Restaurante() {
        this.cardapio = new ArrayList<Prato>();
        this.pedidos = new ArrayList<Pedido>();
    }

    public void adicionarPrato(Prato prato) {
        cardapio.add(prato);
    }

    public void fazerPedido(Prato prato, int quantidade, int mesa) {
        Pedido pedido = new Pedido(mesa);
        Item item = new Item(prato, quantidade);
        pedido.adicionarItem(item);
        pedidos.add(pedido);
    }

    public void imprimirCardapio() {
        System.out.println("*** Cardápio ***");
        for (Prato prato : cardapio) {
            System.out.printf("%d. %s (%s) - R$%.2f\n", prato.getNumero(), prato.getNome(), prato.getDescricao(), prato.getPreco());
        }
    }

    public void imprimirPedidos() {
        System.out.println("*** Pedidos ***");
        for (Pedido pedido : pedidos) {
            System.out.printf("Mesa %d:\n", pedido.getMesa());
            ArrayList<Item> itens = pedido.getItens();
            for (Item item : itens) {
                System.out.printf("- %s (%d) - R$%.2f\n", item.getPrato().getNome(), item.getQuantidade(), item.getPrato().getPreco());
            }
            System.out.printf("Total: R$%.2f\n", pedido.getTotal());
        }
    }

    public Prato getPrato(int numero) {
        for (Prato prato : cardapio) {
            if (prato.getNumero() == numero) {
                return prato;
            }
        }
        return null;
    }
}
