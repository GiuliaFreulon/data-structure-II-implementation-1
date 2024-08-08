package MetodosSort;
import java.util.*;
import java.util.stream.Collectors;
public class BHSISort<T extends Comparable<T>> {

    static long comparacoes = 0L;
    static long movimentacoes = 0L;

    private BuildHeap<T> heapBuilder = new BuildHeap<>();
    private SelectSort<T> selectionSorter = new SelectSort<>();
    private InsertionSort<T> insertionSorter = new InsertionSort<>();

    public T[] bhsiSort(T[] array, int e) {
        comparacoes = 0L;
        movimentacoes = 0L;

        // Chama o método para construir o heap
        heapBuilder.buildHeap(array);
        comparacoes += heapBuilder.getComparacoes();
        movimentacoes += heapBuilder.getMovimentacoes();

        // Calcula o valor de elementos das extremidades de acordo com a porcentagem E
        int n = array.length;
        int limite = (int) (e * n)/100;

        // Cria um vetor começo para armazenar as %E extremidades menores do vetor
        T[] comeco = encontrarMenores(array, limite);
        // Cria um vetor fim para armazenar as %E extremidades maiores do vetor
        T[] fim = encontrarMaiores(array,limite);
        // Criar um vetor meio para armazenar os elementos do vetor que não estão nem no começo, nem no fim
        T[] meio = removerElementosComuns(array, comeco);
        meio = removerElementosComuns(meio, fim);

        // Ordena a extremidade inicial com SelectionSort
        selectionSorter.sort(comeco);
        comparacoes += selectionSorter.getComparacoes();
        movimentacoes += selectionSorter.getMovimentacoes();

        // Ordena a extremidade final com SelectionSort
        selectionSorter.sort(fim);
        comparacoes += selectionSorter.getComparacoes();
        movimentacoes += selectionSorter.getMovimentacoes();

        // Ordena os elementos centrais com InsertionSort
        insertionSorter.sort(meio);
        comparacoes += insertionSorter.getComparacoes();
        movimentacoes += insertionSorter.getMovimentacoes();

        // Junta os vetores começo, meio e fim
        return combinarArrays(comeco,meio,fim);
    }

    // Método para juntar os vetores
    public T[] combinarArrays(T[] array1, T[] array2, T[] array3) {
        // Calcula o tamanho total do vetor final
        int tamanhoTotal = array1.length + array2.length + array3.length;

        // Copia os elementos dos três vetores para o vetor final, na ordem array1,array2,array3
        T[] resultado = Arrays.copyOf(array1, tamanhoTotal);
        System.arraycopy(array2, 0, resultado, array1.length, array2.length);
        System.arraycopy(array3, 0, resultado, array1.length + array2.length, array3.length);
        movimentacoes += 4;

        return resultado;
    }

    // Remove elementos do vetor1 que são comuns com o vetor2, mas remove apenas o número de instâncias que tem no vetor2
    public T[] removerElementosComuns(T[] vetor1, T[] vetor2) {
        // Cria um mapa para contar o número de ocorrências dos elementos no vetor1
        Map<T, Long> count1 = Arrays.stream(vetor1)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        // Cria um mapa para contar o número de ocorrências dos elementos no vetor2
        Map<T, Long> count2 = Arrays.stream(vetor2)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        // Cria uma lista para guardar os elementos que não são comuns
        List<T> resultado = new ArrayList<>();

        // Itera o vetor1
        for (T elemento : vetor1) {
            // Calcula a diferença entre as ocorrências de um elemento no vetor1 e no vetor2
            long instancia = count1.get(elemento) - count2.getOrDefault(elemento, 0L);
            movimentacoes++;
            // Se o elemento for mais comum no vetor1 do que no vetor2, ele é adicionado no resultado
            if (instancia > 0) {
                comparacoes++;
                resultado.add(elemento);
                // Atualiza o contador desse elemento em count1
                count1.put(elemento, instancia);
                movimentacoes += 2;
            }
        }

        // Converte a lista resultado em um vetor
        return resultado.toArray(Arrays.copyOf(vetor1, 0));
    }


    public T[] encontrarMaiores(T[] vetor, int x) {
        // Cria um vetor com tamanho x, copiando os primeiros x elementos do vetor dado
        T[] maiores = Arrays.copyOf(vetor, x);

        // Itera pelo vetor a partir de x+1
        for (int i = x; i < vetor.length; i++) {
            comparacoes++;
            T elementoAtual = vetor[i];
            movimentacoes++;

            // Encontra o índice do menor elemento nos x maiores
            int indiceMenor = 0; // Inicializa com o índice do primeiro elemento
            // Itera pelo vetor maiores
            for (int j = 1; j < x; j++) {
                comparacoes++;
                // Se o elemento atual no vetor maiores for menor que o menor dos x maiores, atualiza o índice do menor
                if (maiores[j].compareTo(maiores[indiceMenor]) < 0) {
                    comparacoes++;
                    indiceMenor = j;
                    movimentacoes++;
                }
            }

            // Se o elemento atual for maior que o menor dos x maiores, substitui-o. Isso garante que o vetor maiores sempre vai ter os maiores elementos
            if (elementoAtual.compareTo(maiores[indiceMenor]) > 0) {
                comparacoes++;
                maiores[indiceMenor] = elementoAtual;
                movimentacoes++;
            }
        }

        return maiores;
    }

    public T[] encontrarMenores(T[] vetor, int x) {
        // Cria um vetor com tamanho x, copiando os primeiros x elementos do vetor dado
        T[] menores = Arrays.copyOf(vetor, x);

        // Itera pelo vetor a partir de x+1
        for (int i = x; i < vetor.length; i++) {
            comparacoes++;
            T elementoAtual = vetor[i];
            movimentacoes++;

            // Encontra o índice do maior elemento nos x menores
            int indiceMaior = 0; // Inicializa com o índice do primeiro elemento
            // Itera pelo vetor menores
            for (int j = 1; j < x; j++) {
                comparacoes++;
                // Se o elemento atual no vetor menores for maior que o maior dos x menores, atualiza o índice do maior
                if (menores[j].compareTo(menores[indiceMaior]) > 0) {
                    comparacoes++;
                    indiceMaior = j;
                    movimentacoes++;
                }
            }

            // Se o elemento atual for menor que o maior dos x menores, substitui-o. Isso garante que o vetor menores sempre vai ter os menores elementos
            if (elementoAtual.compareTo(menores[indiceMaior]) < 0) {
                comparacoes++;
                menores[indiceMaior] = elementoAtual;
                movimentacoes++;
            }
        }

        return menores;
    }


    public long getComparacoes() {
        return comparacoes;
    }

    public long getMovimentacoes() {
        return movimentacoes;
    }
}
