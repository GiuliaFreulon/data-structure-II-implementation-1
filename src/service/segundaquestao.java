package service;

import MetodosSort.MergeSort;
import java.util.Arrays;

public class segundaquestao {
    static long movimentacoes = 0L;
    static long comparacoes = 0L;
    public static void inteiro(int tamanho) {
        movimentacoes = 0;
        comparacoes = 0;

        Integer[] array1 = gerenciarVetor.GeradorDeVetor.gerarVetorInteiro(tamanho);
        Integer[] array2 = gerenciarVetor.GeradorDeVetor.gerarVetorInteiro(tamanho);

        CalcularMediana<Integer> intCalcularMediana = new CalcularMediana<>();
        long tempoinicial = System.currentTimeMillis();
        Integer intMedian = intCalcularMediana.calculaMediana(array1, array2);
        long tempofinal = System.currentTimeMillis();
        long tempoDeExecucao = tempofinal - tempoinicial;
        System.out.println("Mediana: " + intMedian);
        System.out.println("\nTempo de execução: " + tempoDeExecucao + "ms" +
                           "\nMovimentações: "     + movimentacoes +
                           "\nComparações: "       + comparacoes);
        System.out.println();
    }

    public static void racional(int tamanho) {

        Double[] array1 = gerenciarVetor.GeradorDeVetor.gerarVetorDouble(tamanho);
        Double[] array2 = gerenciarVetor.GeradorDeVetor.gerarVetorDouble(tamanho);

        CalcularMediana<Double> doubleCalcularMediana = new CalcularMediana<>();
        long tempoinicial = System.currentTimeMillis();
        Double doubleMedian = doubleCalcularMediana.calculaMediana(array1, array2);
        long tempofinal = System.currentTimeMillis();
        long tempoDeExecucao = tempofinal - tempoinicial;
        System.out.println("Mediana: " + doubleMedian);
        System.out.println("\nTempo de execução: " + tempoDeExecucao + "ms" +
                           "\nMovimentações: "     + movimentacoes +
                           "\nComparações: "       + comparacoes);
        System.out.println();
    }

    public static void string(int tamanho) {
        String[] array1 = gerenciarVetor.GeradorDeVetor.gerarVetorString(tamanho);
        String[] array2 = gerenciarVetor.GeradorDeVetor.gerarVetorString(tamanho);

        CalcularMediana<String> stringCalcularMediana = new CalcularMediana<>();
        long tempoinicial = System.currentTimeMillis();
        String stringMedian = stringCalcularMediana.calculaMediana(array1, array2);
        long tempofinal = System.currentTimeMillis();
        long tempoDeExecucao = tempofinal - tempoinicial;
        System.out.println("Mediana: " + stringMedian);
        System.out.println("\nTempo de execução: " + tempoDeExecucao + "ms" +
                           "\nMovimentações: "     + movimentacoes +
                           "\nComparações: "       + comparacoes);
        System.out.println();
    }


    public static class CalcularMediana<T extends Comparable<T>> {

        public T calculaMediana(T[] array1, T[] array2) {

            // Calcula o tamanho total do vetor final
            int totalLength = array1.length * 2;

            // Cria um vetor com o tamanho vetor1+vetor2 copiando os elementos do vetor1 para ele
            T[] mergedArray = Arrays.copyOf(array1, totalLength);

            // Copia os elementos do vetor 2 no fim do vetor final
            System.arraycopy(array2, 0, mergedArray, array1.length, array2.length);

            MergeSort sorter = new MergeSort();

            // Ordena o vetor com MergeSort
            sorter.mergeSort(mergedArray);
            comparacoes += sorter.getComparacoes();
            movimentacoes += sorter.getMovimentacoes();

            // Encontra o centro do vetor
            int meio = totalLength / 2;
            if (totalLength % 2 == 0) {
                // Se o tamanho total for par, calcula a média dos dois elementos do meio
                comparacoes++;
                T meio1 = mergedArray[meio - 1];
                T meio2 = mergedArray[meio];
                movimentacoes += 2;
                return calculaMedia(meio1, meio2);
            } else {
                // Se o tamanho total for ímpar, retorna o elemento do meio
                return mergedArray[meio];
            }
        }

        // Método para encontrar a média de acordo com o tipo do vetor
        private T calculaMedia(T a, T b) {
            if (a instanceof String) {
                // Se o tipo for String, faz a concatenação dos dois itens do meio
                comparacoes++;
                String strA = (String) a;
                String strB = (String) b;
                movimentacoes++;
                return (T) (strA + strB);
            }
            else if (a instanceof Double) {
                comparacoes++;
                // Se for do tipo Double, calcula a média dos dois elementos do meio
                double valorA = Double.parseDouble(a.toString());
                double valorB = Double.parseDouble(b.toString());
                double media = (valorA + valorB) / 2.0;
                movimentacoes += 3;
                return (T) Double.valueOf(media);
            }
            else{
                // Se for do tipo Inteiro, calcula a média dos dois elementos do meio
                comparacoes++;
                int valorA = Integer.parseInt(a.toString());
                int valorB = Integer.parseInt(b.toString());
                int media = (valorA + valorB) / 2;
                movimentacoes += 3;
                return (T) Integer.valueOf(media);
            }
        }
    }

}

