package com.mycompany.praticando;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Scanner;

public class PilhaDeMusica {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        Stack<String> pilha = new Stack();

        while (true) {

            System.out.println("===== MENU =====");

            System.out.println("1 - Adicionar Musica");

            System.out.println("2 - Tocar Próxima");

            System.out.println("3 - Listar Musicas");

            System.out.println("0 - Sair");

            int escolha = lerInt();

            switch (escolha) {

                case 1:
                    System.out.println("Qual nome da musica:");
                    String musica = ler.nextLine();
                    
                    adicionarPilha(musica, pilha);
                    System.out.println("Musica adicionada com sucesso!");
                    break;

                case 2:
                    String proxima = tocarProxima(pilha);
                    System.out.println("A proxima musica é: " + proxima);
                    break;

                case 3:
                    listarMusicas(pilha);
                    break;

                case 0:
                    return;

                default:

                    System.out.println("Escolha invalida.");

            }

        }

    }
    
    public static void adicionarPilha(String musica, Stack<String> pilha){
        pilha.push(musica);
        
    }
   
    public static String tocarProxima(Stack<String> pilha) {
        try {
            return pilha.pop();
        } catch (EmptyStackException e) {
            return "Não há músicas na PlayList para tocar!";
        }
    }
    
    public static void listarMusicas(Stack<String> pilha){
        System.out.println("===== PlayList =====");
        System.out.println();
        int i=pilha.size();
          for (String item : pilha) {
              System.out.println(i+ " " + item);
              i--;
          }
    }

    public static int lerInt() {

        while (true) {

            var linha = ler.nextLine();

            try {

                return Integer.parseInt(linha);

            } catch (NumberFormatException erro) {

                System.out.println("Digite um número inteiro.");

            }
        }
    }
}
