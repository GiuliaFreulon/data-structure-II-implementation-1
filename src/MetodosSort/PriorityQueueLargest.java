package MetodosSort;

import java.util.*;
public class PriorityQueueLargest <T extends Comparable<T>> {

    static long comparacoes = 0L;
    static long movimentacoes = 0L;

    public ArrayList<T> encontrarMaior(T[] inputArray, int[] valoresK) {
        comparacoes = 0;
        movimentacoes = 0;

        ArrayList<T> result = new ArrayList<>();
        
        //Itera sobre cada valor k
        for (int i = 0; i < valoresK.length; i++) {
            comparacoes++;
            int k = valoresK[i];
            // Chama o método para encontrar o maior k e adiciona-o no vetor de maiores
            T Maior = EncontrarMaior(inputArray, k);
            result.add(Maior);
            movimentacoes += 3;
        }

        return result;
    }

    private T EncontrarMaior(T[] inputArray, int k) {
        // Cria um max-heap com um comparador que ordena os elementos em ordem decrescente
        PriorityQueue<T> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));

        // Itera sobre os elementos de V1
        for (T element : inputArray) {
            // Adiciona o elemento no max-heap
            maxHeap.offer(element);
            movimentacoes++;

            // Se o tamanho do max-heap excede k, remove o menor elemento do heap
            if (maxHeap.size() > k) {
                comparacoes++;
                maxHeap.poll(); // Mantém apenas os maiores k elementos
                movimentacoes++;
            }
        }

        return maxHeap.peek(); // O elemento no topo do max-heap é o k-ésimo maior
    }


    public long getComparacoes() {
        return comparacoes;
    }

    public long getMovimentacoes() {
        return movimentacoes;
    }

}

