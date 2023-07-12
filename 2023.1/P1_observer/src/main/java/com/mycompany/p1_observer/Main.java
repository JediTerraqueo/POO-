package com.mycompany.p1_observer;

public class Main {
    public static void main(String[] args) {
        Pedido pedidos = new Pedido();
        App app = new App();
        pedidos.attach(app);
        pedidos.processarPedidos("src\\main\\java\\com\\mycompany\\p1_observer\\pedidos.txt");
    }
}

