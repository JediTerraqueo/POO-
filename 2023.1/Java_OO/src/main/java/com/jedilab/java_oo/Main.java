package com.jedilab.java_oo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection collection;
        System.out.println("Escolha o tipo de coleção:");
        System.out.println("1. Lista encadeada");
        System.out.println("2. Vetor");
        int choice = scanner.nextInt();
        if (choice == 1) {
            collection = new LinkedList();
        } else {
            collection = new Vector();
        }

        while (true) {
            System.out.println();
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar um número à coleção");
            System.out.println("2. Remover um número da coleção");
            System.out.println("3. Verificar se a coleção contém um número");
            System.out.println("4. Imprimir a coleção");
            System.out.println("5. Sair");

            int option = scanner.nextInt();
            if (option == 1) {
                System.out.print("Digite um número para adicionar à coleção: ");
                int number = scanner.nextInt();
                collection.add(number);
                System.out.println("O número " + number + " foi adicionado à coleção.");
            } else if (option == 2) {
                System.out.print("Digite um número para remover da coleção: ");
                int number = scanner.nextInt();
                collection.remove(number);
                System.out.println("O número " + number + " foi removido da coleção.");
            } else if (option == 3) {
                System.out.print("Digite um número para verificar se está na coleção: ");
                int number = scanner.nextInt();
                if (collection.contains(number)) {
                    System.out.println("A coleção contém o número " + number + ".");
                } else {
                    System.out.println("A coleção não contém o número " + number + ".");
                }
            } else if (option == 4) {
                int[] array = collection.toArray();
                System.out.print("A coleção contém os números: ");
                for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();
            } else if (option == 5) {
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
