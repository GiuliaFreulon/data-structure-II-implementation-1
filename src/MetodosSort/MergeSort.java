package MetodosSort;

import java.util.Arrays;

public class MergeSort {

    static long comparacoes = 0L;
    static long movimentacoes = 0L;

    public static <T extends Comparable<? super T>> void mergeSort(T[] array) {
        comparacoes = 0L;
        movimentacoes = 0L;

        //Encontra o tamanho do vetor
        int n = array.length;

        // Se o tamanho for <= 1, significa que o vetor não precisa ser ordenado
        if (n <= 1) {
            return;
        }

        // Se o tamanho for > 1, encontra o meio do vetor
        int mid = n / 2;

        // Divide o vetor em esquerda e direita
        T[] esquerda = Arrays.copyOfRange(array, 0, mid);
        T[] direita = Arrays.copyOfRange(array, mid, n);

        // Recursivamente ordena a parte esquerda, depois a parte direita do vetor
        mergeSort(esquerda);
        mergeSort(direita);

        // Junta as partes já ordenadas
        merge(array, esquerda, direita);
    }

    private static <T extends Comparable<? super T>> void merge(T[] array, T[] esquerda, T[] direita) {
        // Encontra o tamanho das partes da esquerda e direita
        int tamanhoEsquerda = esquerda.length;
        int tamanhoDireita = direita.length;

        // Inicializa os ponteiros i=esquerda, j=direita e k=esquerda+direita
        int i = 0, j = 0, k = 0;

        // Inicia um loop que itera sobre o lado esquerdo e direito do vetor
        while (i < tamanhoEsquerda && j < tamanhoDireita) {
            comparacoes += 2;
            // Se o elemento da esquerda é menor ou igual ao da direita, copia o elemento da esquerda para o vetor conjunto
            if (esquerda[i].compareTo(direita[j]) <= 0) {
                comparacoes++;
                array[k++] = esquerda[i++];
                movimentacoes++;
            }
            // Caso o contrário, copia o elemento da direita para o vetor conjunto
            else {
                comparacoes++;
                array[k++] = direita[j++];
                movimentacoes++;
            }
        }

        // Caso ainda existam elementos do lado esquerdo, estes são movidos para o fim do vetor conjunto
        while (i < tamanhoEsquerda) {
            comparacoes++;
            array[k++] = esquerda[i++];
            movimentacoes++;
        }

        // Caso ainda existam elementos do lado direito, estes são movidos para o fim do vetor conjunto
        while (j < tamanhoDireita) {
            comparacoes++;
            array[k++] = direita[j++];
            movimentacoes++;
        }
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public long getMovimentacoes() {
        return movimentacoes;
    }

}
