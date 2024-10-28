/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameversãomelhorada;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Pc
 */
public class GameVersãoMelhorada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner ler = new Scanner(System.in);
        Random random = new Random();
        
        String nome;
        int confirmar;
        boolean querJogar = true;
        double totalGanho = 0;
        int vitorias = 0; // Contador de vitórias
        
        System.out.println("Bem-vindo ao jogo de adivinhação!");
        System.out.println("Estou pensando em um número entre 1 e 100...");
        System.out.println("Insira o seu nome: ");
        nome = ler.nextLine();
        
        while (querJogar) {
            int numeroSecreto = random.nextInt(100) + 1;
            int tentativas = 0;
            boolean acertou = false;
            double aposta = 0;
            
            while (!acertou) {
                System.out.println("Insira se você quer jogar ou não 1 - sim ou 0 - não");
                confirmar = ler.nextInt();
                
                if (confirmar == 1) {
                    System.out.println("Você quer jogar: ");
                    
                    // Solicitar valor da aposta
                    System.out.print("Digite o valor da sua aposta: ");
                    aposta = ler.nextDouble();
                    
                    System.out.print("Digite sua tentativa: ");
                    int palpite = ler.nextInt();
                    tentativas++;
                    
                    if (palpite < numeroSecreto) {
                        System.out.println("O número é maior!");
                    } else if (palpite > numeroSecreto) {
                        System.out.println("O número é menor!");
                    } else {
                        acertou = true;
                        vitorias++; // Incrementa contador de vitórias
                        System.out.println("Parabéns, " + nome + "! Você acertou em " + tentativas + " tentativas.");
                        double valorGanho = aposta * 2;
                        totalGanho += valorGanho;
                        System.out.println("Você ganhou " + valorGanho + "! Acumulado total: " + totalGanho);
                        
                        System.out.print("Deseja jogar novamente? 1 - Sim / 0 - Não: ");
                        int jogarNovamente = ler.nextInt();
                        if (jogarNovamente == 1) {
                            querJogar = true;
                        } else {
                            querJogar = false;
                            System.out.println("Obrigado por jogar!");
                            System.out.println("Você venceu " + vitorias + " vez(es) e tem direito a receber um total de: " + totalGanho);
                        }
                    }
                } else {
                    System.out.println("Você não quer jogar: ");
                    querJogar = false;
                    System.out.println("Obrigado por jogar!");
                    System.out.println("Você venceu " + vitorias + " vez(es) e tem direito a receber um total de: " + totalGanho);
                    break;
                }
            }
        }
        
        ler.close();
    }
}
