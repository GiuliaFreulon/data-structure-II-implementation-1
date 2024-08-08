package MetodosSort;

public class SelectSort<T extends Comparable<T>> {

    static long comparacoes = 0L;
    static long movimentacoes = 0L;
    public static <T extends Comparable<? super T>> void sort(T[] arr) {
        comparacoes = 0L;
        movimentacoes = 0L;

        int n = arr.length; // Encontra o tamanho do vetor

        for (int i = 0; i < n - 1; i++) { // Itera sobre o vetor
            comparacoes++;
            int minIndex = i; // Assume que o elemento atual é o menor
            movimentacoes++;

            // Encontra o índice do menor elemento na parte não ordenada do vetor
            for (int j = i + 1; j < n; j++) {
                comparacoes++;
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    comparacoes++;
                    minIndex = j; // Atualiza o minIndex se um elemento menor é encontrado
                    movimentacoes++;
                }
            }

            // Troca o menor elemento com o atual elemento(o coloca em ordem)
            T temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            movimentacoes += 3;
        }

    }

    public long getComparacoes() {
        return comparacoes;
    }

    public long getMovimentacoes() {
        return movimentacoes;
    }

}


