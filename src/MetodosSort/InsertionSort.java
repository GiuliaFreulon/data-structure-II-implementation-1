package MetodosSort;

public class InsertionSort<T extends Comparable<T>> {

    static long comparacoes = 0L;
    static long movimentacoes = 0L;
    public static <T extends Comparable<? super T>> void sort(T[] array) {
        comparacoes = 0L;
        movimentacoes = 0L;

        int n = array.length; // Encontra o tamanho do vetor

        // Itera pelo vetor começando pelo segundo elemento
        for (int i = 1; i < n; i++) {
            comparacoes++;
            T chave = array[i]; // Guarda o elemento atual(chave) para ser inserido
            int j = i - 1; // Inicializa j como o elemento anterior à chave

            // Move os elementos do vetor que são maiores que a chave para uma posição à frente de sua posição atual
            while (j >= 0 && array[j].compareTo(chave) > 0) {
                comparacoes += 2;
                array[j + 1] = array[j]; // Move o maior elementos uma posição à frente
                movimentacoes++;
                j--; // Move o ponteiro para o elemento anterior
            }

            // Insere a chave na posição correta do vetor ordenado
            array[j + 1] = chave;
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
