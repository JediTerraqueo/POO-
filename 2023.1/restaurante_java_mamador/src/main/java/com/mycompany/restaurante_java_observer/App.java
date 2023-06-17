package com.mycompany.restaurante_java_observer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    private List<Prato> pratos;
    private List<Pedido> pedidos;
    private int proximoNumeroPedido;

    public App() {
        pratos = new ArrayList<>();
        pedidos = new ArrayList<>();
        proximoNumeroPedido = 1;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void adicionarPrato(Prato prato) {
        pratos.add(prato);
    }

    public void salvarPratos(String arquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo))) {
            for (Prato prato : pratos) {
                writer.println(prato.getNome());
                writer.println(prato.getPreco());
                writer.println(prato.getDescricao());
                writer.println("---");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public void carregarPratos(String arquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 3) {
                    String nome = dados[0];
                    String descricao = dados[1];
                    double preco = Double.parseDouble(dados[2]);

                    Prato prato = new Prato(nome, descricao, preco);
                    pratos.add(prato);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de pratos: " + e.getMessage());
        }
    }

    public Pedido criarPedido() {
        Pedido pedido = new Pedido(proximoNumeroPedido);
        pedidos.add(pedido);
        proximoNumeroPedido++;
        return pedido;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void salvarPedidos(String arquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo))) {
            for (Pedido pedido : pedidos) {
                writer.println(pedido.getNumero());
                for (Item item : pedido.getItens()) {
                    writer.println(item.getPrato().getNome());
                    writer.println(item.getQuantidade());
                }
                writer.println("---");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarPedidos(String arquivo) {
        pedidos.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String line;
            int numero = 0;
            List<Item> itens = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (line.equals("---")) {
                    Pedido pedido = new Pedido(numero);
                    for (Item item : itens) {
                        pedido.adicionarItem(item);
                    }
                    pedidos.add(pedido);

                    numero = 0;
                    itens.clear();
                } else if (numero == 0) {
                    numero = Integer.parseInt(line);
                } else {
                    String nomePrato = line;
                    int quantidade = Integer.parseInt(reader.readLine());

                    Prato prato = buscarPrato(nomePrato);
                    if (prato != null) {
                        Item item = new Item(prato, quantidade);
                        itens.add(item);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Prato buscarPrato(String nome) {
        for (Prato prato : pratos) {
            if (prato.getNome().equals(nome)) {
                return prato;
            }
        }
        return null;
    }
}
