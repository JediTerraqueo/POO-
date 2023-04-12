import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LiderCampeonato {

    public static void main(String[] args) {
        
        // Ler a matriz de resultados do arquivo
        int[][] tabela = lerMatriz("src/main/java/resultados.txt");
        
        // Imprimir a matriz lida
        System.out.println();
        System.out.println("Matriz de resultados:");
        imprimirMatriz(tabela);
        
        // Obter o líder do campeonato
        int lider = obterLider(tabela);
        System.out.println();
        System.out.println("O líder do campeonato é o time " + lider);
        
    }
    
    public static int[][] lerMatriz(String nomeArquivo) {
        
        try {
            File arquivo = new File(nomeArquivo);
            Scanner scanner = new Scanner(arquivo);
            
            int n = scanner.nextInt();
            int[][] tabela = new int[n][4];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 4; j++) {
                    tabela[i][j] = scanner.nextInt();
                }
            }
            
            scanner.close();
            return tabela;
            
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
            return null;
        }
        
    }
    
    public static void imprimirMatriz(int[][] matriz) {
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
    public static int obterLider(int[][] tabela) {
        
        int lider = 0;
        int pontosLider = tabela[0][0];
        int vitoriasLider = tabela[0][1];
        int saldoLider = tabela[0][2];
        int golsLider = tabela[0][3];
        
        for (int i = 1; i < tabela.length; i++) {
            int pontos = tabela[i][0];
            int vitorias = tabela[i][1];
            int saldo = tabela[i][2];
            int gols = tabela[i][3];
            
            if (pontos > pontosLider ||
                (pontos == pontosLider && vitorias > vitoriasLider) ||
                (pontos == pontosLider && vitorias == vitoriasLider && saldo > saldoLider) ||
                (pontos == pontosLider && vitorias == vitoriasLider && saldo == saldoLider && gols > golsLider)) {
                    
                lider = i;
                pontosLider = pontos;
                vitoriasLider = vitorias;
                saldoLider = saldo;
                golsLider = gols;
                    
            }
        }
        
        return lider + 1;
        
    }
    
}
