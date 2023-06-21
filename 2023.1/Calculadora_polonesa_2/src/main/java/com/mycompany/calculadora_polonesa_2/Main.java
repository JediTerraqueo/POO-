package com.mycompany.calculadora_polonesa_2;

import java.util.Scanner;
import java.util.List;

// Classe principal para interação com o usuário
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraFacade facade = new CalculadoraFacade();

        while (true) {
            System.out.println("=== Calculadora Polonesa Reversa ===");
            System.out.println("Digite a expressão a ser calculada:");
            String expressao = scanner.nextLine();

            try {
                double resultado = facade.calcularExpressao(expressao);
                System.out.println("Resultado: " + resultado);
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

            System.out.println();
            System.out.println("Variáveis disponíveis:");
            List<String> variaveis = facade.getVariaveisDisponiveis();
            for (String variavel : variaveis) {
                double valor = facade.getVariavel(variavel);
                System.out.println(variavel + " = " + valor);
            }

            System.out.println();
            System.out.println("Deseja alterar alguma variável? (S/N)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("S")) {
                System.out.println("Digite o nome da variável:");
                String nomeVariavel = scanner.nextLine();
                System.out.println("Digite o novo valor:");
                double novoValor = scanner.nextDouble();
                scanner.nextLine(); // Consumir a quebra de linha

                facade.setVariavel(nomeVariavel, novoValor);

                System.out.println("Variável atualizada com sucesso!");
            }

            System.out.println();
            System.out.println("Deseja inserir mais variáveis? (S/N)");
            resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("S")) {
                System.out.println("Digite o nome da variável (ou 'sair' para encerrar):");
                String nomeVariavel = scanner.nextLine();

                while (!nomeVariavel.equalsIgnoreCase("sair")) {
                    System.out.println("Digite o valor da variável:");
                    double valorVariavel = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linha

                    facade.setVariavel(nomeVariavel, valorVariavel);

                    System.out.println("Variável adicionada com sucesso!");

                    System.out.println("Digite o nome da variável (ou 'sair' para encerrar):");
                    nomeVariavel = scanner.nextLine();
                }
            }

            System.out.println();
            System.out.println("Deseja realizar outra operação? (S/N)");
            resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("S")) {
                break;
            }

            System.out.println();
        }

        System.out.println("Encerrando a calculadora...");
        scanner.close();
    }
}
