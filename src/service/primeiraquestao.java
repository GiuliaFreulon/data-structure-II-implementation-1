package service;

import MetodosSort.PriorityQueueLargest;
import java.util.ArrayList;

public class primeiraquestao {

    static long comparacoes = 0L;
    static long movimentacoes = 0L;

    public static void inteiro(int tamanho) {

        movimentacoes = 0;
        comparacoes = 0;

        Integer[] V1 = gerenciarVetor.GeradorDeVetor.gerarVetorInteiro(tamanho);
        int P[] = null;

        // Garante que o vetor P vai abrangir o vetor V1 inteiro
        if(tamanho == 1000) {
            P = gerenciarVetor.GeradorDeVetor.gerarVetorTamanhoAleatorio(5, 999);
        }
        else if(tamanho == 100000){
            P = gerenciarVetor.GeradorDeVetor.gerarVetorTamanhoAleatorio(5, 99999);
        }
        else if(tamanho == 1000000){
            P = gerenciarVetor.GeradorDeVetor.gerarVetorTamanhoAleatorio(5, 999999);
        }

        long tempoinicial = System.currentTimeMillis();
        PriorityQueueLargest<Integer> inteiroMaior = new PriorityQueueLargest<>();
        ArrayList<Integer> intResult = inteiroMaior.encontrarMaior(V1, P);
        long tempofinal = System.currentTimeMillis();
        long tempoDeExecucao = tempofinal - tempoinicial;

        comparacoes += inteiroMaior.getComparacoes();
        movimentacoes += inteiroMaior.getMovimentacoes();

        System.out.println("Maiores rj-esimos do Vetor = " + intResult);
        System.out.println("\nTempo de execução: " + tempoDeExecucao + "ms" +
                           "\nMovimentações: "     + movimentacoes +
                           "\nComparações: "       + comparacoes);
        System.out.println();
    }

    public static void racional(int tamanho) {

        movimentacoes = 0;
        comparacoes = 0;

        Double[] V1 = gerenciarVetor.GeradorDeVetor.gerarVetorDouble(tamanho);
        int P[] = null;

        // Garante que o vetor P vai abrangir o vetor V1 inteiro
        if(tamanho == 1000) {
            P = gerenciarVetor.GeradorDeVetor.gerarVetorTamanhoAleatorio(5, 999);
        }
        else if(tamanho == 100000){
            P = gerenciarVetor.GeradorDeVetor.gerarVetorTamanhoAleatorio(5, 99999);
        }
        else if(tamanho == 1000000){
            P = gerenciarVetor.GeradorDeVetor.gerarVetorTamanhoAleatorio(5, 999999);
        }

        long tempoinicial = System.currentTimeMillis();
        PriorityQueueLargest<Double> doubleMaior = new PriorityQueueLargest<>();
        ArrayList<Double> doubleResult = doubleMaior.encontrarMaior(V1, P);
        long tempofinal = System.currentTimeMillis();
        long tempoDeExecucao = tempofinal - tempoinicial;

        comparacoes += doubleMaior.getComparacoes();
        movimentacoes += doubleMaior.getMovimentacoes();

        System.out.println("Maiores rj-esimos do Vetor = " + doubleResult);
        System.out.println("\nTempo de execução: " + tempoDeExecucao + "ms" +
                           "\nMovimentações: "     + movimentacoes +
                           "\nComparações: "       + comparacoes);
        System.out.println();
    }


    public static void string(int tamanho) {

        movimentacoes = 0;
        comparacoes = 0;

        String[] V1 = gerenciarVetor.GeradorDeVetor.gerarVetorString(tamanho);
        int P[] = null;

        // Garante que o vetor P vai abrangir o vetor V1 inteiro
        if(tamanho == 1000) {
            P = gerenciarVetor.GeradorDeVetor.gerarVetorTamanhoAleatorio(5, 999);
        }
        else if(tamanho == 100000){
            P = gerenciarVetor.GeradorDeVetor.gerarVetorTamanhoAleatorio(5, 99999);
        }
        else if(tamanho == 1000000){
            P = gerenciarVetor.GeradorDeVetor.gerarVetorTamanhoAleatorio(5, 999999);
        }

        long tempoinicial = System.currentTimeMillis();
        PriorityQueueLargest<String> stringMaior = new PriorityQueueLargest<>();
        ArrayList<String> strResult = stringMaior.encontrarMaior(V1, P);
        long tempofinal = System.currentTimeMillis();
        long tempoDeExecucao = tempofinal - tempoinicial;

        comparacoes += stringMaior.getComparacoes();
        movimentacoes += stringMaior.getMovimentacoes();

        System.out.println("Maiores rj-esimos do Vetor = " + strResult);
        System.out.println("\nTempo de execução: " + tempoDeExecucao + "ms" +
                           "\nMovimentações: "     + movimentacoes +
                           "\nComparações: "       + comparacoes);
        System.out.println();
    }
}
