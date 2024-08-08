package MetodosSort;

public class BuildHeap<T extends Comparable<T>> {

    static long comparacoes = 0L;
    static long movimentacoes = 0L;
    public void buildHeap(T[] array) {
        comparacoes = 0L;
        movimentacoes = 0L;

        // Calcula o tamanho do vetor
        int n = array.length;

        // Transforma o vetor em um heap (árvore binária)
        for (int i = n / 2 - 1; i >= 0; i--) {
            comparacoes++;
            heapify(array, n, i); // Chama o método heapify
        }
    }

    private void heapify(T[] array, int n, int i) {
        int maior = i; // Inicia o maior elemento como o índice atual de i
        int filhoEsquerda = 2 * i + 1; // Calcula o índice do filho esquerdo
        int filhoDireita = 2 * i + 2;  // Calcula o índice do filho direito

        // Encontra o maior elemento entre o pai, o filho esquerdo e o filho direito
        // Caso em que o filho da esquerda é o maior
        if (filhoEsquerda < n && array[filhoEsquerda].compareTo(array[maior]) > 0) {
            comparacoes += 2;
            maior = filhoEsquerda;
            movimentacoes++;
        }

        // Caso em que o filho da direita é o maior
        if (filhoDireita < n && array[filhoDireita].compareTo(array[maior]) > 0) {
            comparacoes += 2;
            maior = filhoDireita;
            movimentacoes++;
        }

        // Se o maior elemento não for o pai, troca o pai com o maior e continua a heapificação
        if (maior != i) {
            comparacoes++;
            T temp = array[i];
            array[i] = array[maior];
            array[maior] = temp;
            movimentacoes += 3;

            // Recursivamente heapifica a subárvore afetada
            heapify(array, n, maior);
        }
    }



    public long getComparacoes() {
        return comparacoes;
    }

    public long getMovimentacoes() {
        return movimentacoes;
    }
}
