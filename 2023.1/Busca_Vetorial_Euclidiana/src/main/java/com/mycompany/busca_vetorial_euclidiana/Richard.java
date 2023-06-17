package com.mycompany.busca_vetorial_euclidiana;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Richard {
    public static void main(String[] args) {
        Rasmussen buscador;
        int numeroResultados;
        double[] vetorConsulta;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite a quantidade de dados: ");
            int quantidadeDados = scanner.nextInt();
            buscador = new Rasmussen();
            // Adicionar dados de exemplo
            Random random = new Random();
            for (int i = 0; i < quantidadeDados; i++) {
                String chave = "Dado " + i;
                double[] vetor = new double[3];
                vetor[0] = random.nextDouble();
                vetor[1] = random.nextDouble();
                vetor[2] = random.nextDouble();
                buscador.adicionarDados(chave, vetor);
            }   System.out.print("Digite o número de resultados desejados: ");
            numeroResultados = scanner.nextInt();
            System.out.println("Digite as coordenadas do vetor de consulta:");
            System.out.print("Coordenada x: ");
            double coordenadaX = scanner.nextDouble();
            System.out.print("Coordenada y: ");
            double coordenadaY = scanner.nextDouble();
            System.out.print("Coordenada z: ");
            double coordenadaZ = scanner.nextDouble();
            vetorConsulta = new double[]{coordenadaX, coordenadaY, coordenadaZ};
            System.out.println("\n");
        }
        
        buscador.exibirNuvemDeDados();
        
        // Realizar busca
        List<String> resultados = buscador.buscarDadosMaisProximos(vetorConsulta, numeroResultados);

        // Exibir resultados
        System.out.print("\n");
        System.out.println("Resultados:");
        System.out.print("\n");
        for (String resultado : resultados) {
            System.out.println(resultado);
        }
    }
}
