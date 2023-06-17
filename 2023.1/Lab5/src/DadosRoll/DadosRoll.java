package DadosRoll;

import java.util.Random;
import java.util.Scanner;

public class DadosRoll {
   public static Random rand; //INICIALIZA O RANDOM
   public static Scanner in; //INICIALIZA A ENTRADA DO USUARIO
   public static int numDeDados = 2; //INICIALIZA A QUANTIDADE DE DADOS
   public static int numDeLados = 6; //INICIALIZA A QUANTIDADE DE LADOS

   static {
       rand = new Random();
       in = new Scanner(System.in);
   }
   public static int roll() { //ROLA O DADO
       int dado1 = rand.nextInt(numDeDados + (numDeLados+1));//ROLA DADO 1 
       int dado2 = rand.nextInt(numDeDados+(numDeLados+1)); //ROLA DADO 2
       int rodada = dado1 + dado2; //ARMAZENA O VALOR DOS DOIS DADOS
       return rodada;
    }

   public static boolean round() {
       int primeiroPonto = roll(); //VERIFICA O VALOR DA PRIMEIRA RODADA
       if (primeiroPonto == 7 || primeiroPonto == 11) { //SE VALOR FOR 7 OU 11 NA PRIMEIRA RODADA VOCÊ GANHA
        System.out.println("Ganhou!");
        } else if (primeiroPonto == 2 || primeiroPonto == 3 || primeiroPonto == 12) { //SE VALOR FOR 2, 3 OU 12 NA PRIMEIRA RODADA VOCÊ PERDE
            System.out.println("Perdeu!");

        } else { //SE NÃO FOR NENHUM DESSES ROLE DE NOVO
            int segFase = primeiroPonto;
            segFase = 0;
            while (primeiroPonto != segFase && primeiroPonto !=7) { //FAZ LOOP ATÉ RECEBER UM RESULTADO
                if (segFase == 7) {
                    System.out.println("Perdeu infeliz!"); //SE O VALOR É 7 VOCÊ PERDE
                } else if (segFase == primeiroPonto) {
                    System.out.println("Ganhou mizera!"); //SE FOR IGUAL AO PRIMEIRO VOCÊ GANHA
                } else {
                    System.out.print("Erro. Tente de novo.");
                }
                //CONTINUA ROLANDO ATÉ GANHAR OU PERDER    
            }
        }           
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Quantas rodadas quer jogar?");
        int amtRound = in.nextInt();
        for (int i=1; i<=amtRound; i++) {
            boolean resultado = round();
        }
    }
}