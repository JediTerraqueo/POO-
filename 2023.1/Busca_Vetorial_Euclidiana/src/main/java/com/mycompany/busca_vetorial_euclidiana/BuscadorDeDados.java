package com.mycompany.busca_vetorial_euclidiana;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BuscadorDeDados {
    private List<Dado> dados;

    public BuscadorDeDados() {
        dados = new ArrayList<>();
    }

    public void adicionarDados(String chave, double[] vetor) {
        dados.add(new Dado(chave, vetor));
    }

    public List<String> buscarDadosMaisProximos(double[] vetorConsulta, int numeroResultados) {
        List<Distancia> distancias = new ArrayList<>();

        for (Dado dado : dados) {
            double distancia = calcularDistanciaEuclidiana(vetorConsulta, dado.getVetor());
            distancias.add(new Distancia(dado.getChave(), distancia));
        }

        distancias.sort(new DistanciaComparator());

        List<String> resultados = new ArrayList<>();
        for (int i = 0; i < Math.min(numeroResultados, distancias.size()); i++) {
            resultados.add(distancias.get(i).getChave());
        }

        return resultados;
    }

    public void exibirNuvemDeDados() {
        System.out.println("Nuvem de Dados:");
        for (Dado dado : dados) {
            System.out.println(dado.getChave() + ": " + formatarVetor(dado.getVetor()));
        }
    }

    private double calcularDistanciaEuclidiana(double[] vetor1, double[] vetor2) {
        if (vetor1.length != vetor2.length) {
            throw new IllegalArgumentException("Os vetores têm tamanhos diferentes.");
        }

        double somaQuadrados = 0.0;
        for (int i = 0; i < vetor1.length; i++) {
            somaQuadrados += Math.pow(vetor1[i] - vetor2[i], 2);
        }

        return Math.sqrt(somaQuadrados);
    }

    private String formatarVetor(double[] vetor) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < vetor.length; i++) {
            sb.append(vetor[i]);
            if (i < vetor.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Dado {
        private String chave;
        private double[] vetor;

        public Dado(String chave, double[] vetor) {
            this.chave = chave;
            this.vetor = vetor;
        }

        public String getChave() {
            return chave;
        }

        public double[] getVetor() {
            return vetor;
        }
    }

    private static class Distancia {
        private String chave;
        private double distancia;

        public Distancia(String chave, double distancia) {
            this.chave = chave;
            this.distancia = distancia;
        }

        public String getChave() {
            return chave;
        }

        public double getDistancia() {
            return distancia;
        }
    }

    private static class DistanciaComparator implements Comparator<Distancia> {
        public int compare(Distancia distancia1, Distancia distancia2) {
            return Double.compare(distancia1.getDistancia(), distancia2.getDistancia());
        }
    }
}
