package service;

import MetodosSort.MergeSort;
import java.util.Random;

public class terceiraquestaoB {

    static long comparacoes = 0L;
    static long movimentacoes = 0L;
    public static void inteiro(int tamanho) {

        comparacoes = 0;
        movimentacoes = 0;

        Integer[] V = gerenciarVetor.GeradorDeVetor.gerarVetorInteiro(tamanho);
        Random random = new Random();
        int T = random.nextInt(20) + 1;

        long tempoinicial = System.currentTimeMillis();
        Boolean resultado = temParesComDistanciaT(V, T);
        long tempofinal = System.currentTimeMillis();
        long tempoDeExecucao = tempofinal - tempoinicial;

        System.out.println("T:" + T);
        if (resultado == true){
            System.out.println("Encontrou pelo menos um par com diferença T");
        }
        else{
            System.out.println("Não encontrou um par com diferença T");
        }
        System.out.println("\nTempo de execução: " + tempoDeExecucao + "ms" +
                "\nMovimentações: "     + movimentacoes +
                "\nComparações: "       + comparacoes);
        System.out.println();
    }

    public static boolean temParesComDistanciaT(Integer[] array, int T) {
        // Ordena o vetor com MergeSort
        MergeSort sorter = new MergeSort();
        sorter.mergeSort(array);
        comparacoes += sorter.getComparacoes();
        movimentacoes += sorter.getMovimentacoes();

        // Encontra o tamanho do vetor
        int n = array.length;

        // Itera sobre o vetor
        for (int i = 0; i < n; i++) {
            comparacoes++;

            // Calcula o valor alvo, pois A-B = T então A = B+T
            int alvo = array[i] + T;

            // Criam-se os ponteiros da esquerda e da direita
            int esquerda = i + 1;
            int direita = n - 1;

            movimentacoes += 3;

            // Usa pesquisa binária para encontrar o elemento alvo
            while (esquerda <= direita) {
                comparacoes++;

                // Encontra-se o meio do vetor
                int meio = esquerda + (direita - esquerda) / 2;
                movimentacoes++;

                // Se o elemento no meio = alvo, então encontrou o par
                if (array[meio] == alvo) {
                    comparacoes++;
                    return true; // Par encontrado
                }
                // Se o elemento no meio < alvo, então o ponteiro da esquerda procura o meio do subvetor da direita
                else if (array[meio] < alvo) {
                    comparacoes++;
                    esquerda = meio + 1;
                    movimentacoes++;
                }
                // Se o elemento no meio > alvo, então o ponteiro da direita procura o meio do subvetor da esquerda
                else {
                    comparacoes++;
                    direita = meio - 1;
                    movimentacoes++;
                }
            }
        }

        // Não foram encontrados pares com diferença T
        return false;
    }
}
