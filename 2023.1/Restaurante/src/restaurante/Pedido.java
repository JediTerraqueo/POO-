package restaurante;

import java.util.ArrayList;

public class Pedido {
    private int mesa;
    private ArrayList<Item> itens;

    public Pedido(int mesa) {
        this.mesa = mesa;
        this.itens = new ArrayList<Item>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public int getMesa() {
        return mesa;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public double getTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getQuantidade() * item.getPrato().getPreco();
        }
        return total;
    }
}
