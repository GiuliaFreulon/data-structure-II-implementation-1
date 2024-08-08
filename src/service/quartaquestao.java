package service;

import java.util.Random;
import MetodosSort.*;
import java.util.Arrays;

public class quartaquestao {

    static long comparacoes = 0L;
    static long movimentacoes = 0L;

    public static void inteiro(int tamanho) {
        comparacoes = 0;
        movimentacoes = 0;

        Integer[] array = gerenciarVetor.GeradorDeVetor.gerarVetorInteiro(tamanho);
        Random random = new Random();
        // Define a porcentagem de extremidades ordenadas pelo SelectionSort
        int porcentagem = random.nextInt(51);

        BHSISort<Integer> sorter = new BHSISort<>();
        long tempoinicial = System.currentTimeMillis();

        Integer[] resultado = sorter.bhsiSort(array, porcentagem);

        movimentacoes += sorter.getMovimentacoes();
        comparacoes += sorter.getComparacoes();
        long tempofinal = System.currentTimeMillis();
        long tempoDeExecucao = tempofinal - tempoinicial;

        System.out.println(Arrays.toString(resultado));
        System.out.println(
                "\nTempo de execução: " + tempoDeExecucao + "ms" +
                "\nMovimentações: "     + movimentacoes +
                "\nComparações: "       + comparacoes);
        System.out.println();
    }

    public static void racional(int tamanho) {
        comparacoes = 0;
        movimentacoes = 0;

        Double[] array = gerenciarVetor.GeradorDeVetor.gerarVetorDouble(tamanho);
        Random random = new Random();
        // Define a porcentagem de extremidades ordenadas pelo SelectionSort
        int porcentagem = random.nextInt(51);

        BHSISort<Double> sorter = new BHSISort<>();
        long tempoinicial = System.currentTimeMillis();

        Double[] resultado = sorter.bhsiSort(array, porcentagem);

        movimentacoes += sorter.getMovimentacoes();
        comparacoes += sorter.getComparacoes();
        long tempofinal = System.currentTimeMillis();
        long tempoDeExecucao = tempofinal - tempoinicial;


        System.out.println(Arrays.toString(resultado));
        System.out.println(
                "\nTempo de execução: " + tempoDeExecucao + "ms" +
                "\nMovimentações: "     + movimentacoes +
                "\nComparações: "       + comparacoes);
        System.out.println();
    }

    public static void string(int tamanho) {
        comparacoes = 0;
        movimentacoes = 0;

        String[] array = gerenciarVetor.GeradorDeVetor.gerarVetorString(tamanho);
        Random random = new Random();
        // Define a porcentagem de extremidades ordenadas pelo SelectionSort
        int porcentagem = random.nextInt(51);

        BHSISort<String> sorter = new BHSISort<>();
        long tempoinicial = System.currentTimeMillis();

        String[] resultado = sorter.bhsiSort(array, porcentagem);

        movimentacoes += sorter.getMovimentacoes();
        comparacoes += sorter.getComparacoes();
        long tempofinal = System.currentTimeMillis();
        long tempoDeExecucao = tempofinal - tempoinicial;


        System.out.println(Arrays.toString(resultado));
        System.out.println(
                "\nTempo de execução: " + tempoDeExecucao + "ms" +
                "\nMovimentações: "     + movimentacoes +
                "\nComparações: "       + comparacoes);
        System.out.println();
    }

}
