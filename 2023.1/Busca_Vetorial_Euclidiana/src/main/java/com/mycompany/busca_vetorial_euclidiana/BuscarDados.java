package com.mycompany.busca_vetorial_euclidiana;

import java.util.List;
import java.util.Random;

public class BuscarDados {
    public static void main(String[] args) {
        BuscadorDeDados buscador = new BuscadorDeDados();

        // Adicionar 10 mil dados de exemplo
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            String chave = "Dado " + i;
            double[] vetor = new double[3];
            vetor[0] = random.nextDouble();
            vetor[1] = random.nextDouble();
            vetor[2] = random.nextDouble();
            buscador.adicionarDados(chave, vetor);
        }

        // Exibir a nuvem de dados
        buscador.exibirNuvemDeDados();

        // Realizar busca
        double[] vetorConsulta = new double[]{0.5, 0.5, 0.5};
        int numeroResultados = 10;
        List<String> resultados = buscador.buscarDadosMaisProximos(vetorConsulta, numeroResultados);

        // Exibir resultados
        System.out.println("\n");
        System.out.println("Resultados: ");
        for (String resultado : resultados) {
            System.out.println(resultado);
        }
    }
}
