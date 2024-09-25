package com.mycompany.praticando;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class FilaRestaurante {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        Queue<String> fila = new ArrayDeque();

        while (true) {

            System.out.println("===== MENU =====");

            System.out.println("1 - Nova Reserva");

            System.out.println("2 - Chamar Próximo");

            System.out.println("3 - Listar Reservas");

            System.out.println("0 - Sair");

            int escolha = lerInt();

            switch (escolha) {

                case 1:
                    System.out.println("Qual nome do cliente:");
                    String nome = ler.nextLine();
                    System.out.println("Mesa para quantas pessoas:");
                    int mesa = lerInt();
                    
                    String reserva = nome + " reservou mesa para " + mesa;
                    adicionarFila(reserva, fila);
                    System.out.println("Cliente adicionado com sucesso!");
                    break;
                        
                case 2:
                    String proximo = chamarProximo(fila);
                    System.out.println("O proximo cliente da fila é: " + proximo);
                    break;

                case 3:
                    listarReservas(fila);

                    break;

                case 0:
                    return;

                default:

                    System.out.println("Escolha invalida.");

            }

        }

    }
    
    public static void adicionarFila(String reserva, Queue<String> fila){
        fila.offer(reserva);
        
    }
    
    public static String chamarProximo(Queue<String> fila){
        return fila.poll();
    }
    
    public static void listarReservas(Queue<String> fila){
        System.out.println("===== Lista de Reservas =====");
        System.out.println("");
          for (String item : fila) {
              System.out.println(item);
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