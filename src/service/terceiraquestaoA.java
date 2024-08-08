package service;

import java.util.Random;

public class terceiraquestaoA {
    static long comparacoes = 0L;

    public static void inteiro(int tamanho) {

        comparacoes = 0;

        Integer[] V = gerenciarVetor.GeradorDeVetor.gerarVetorInteiro(tamanho);
        Random random = new Random();
        int T = random.nextInt(20) + 1;

        System.out.println("T:" + T);
        long tempoinicial = System.currentTimeMillis();
        Boolean resultado = temParesComDistanciaT(V, T);
        long tempofinal = System.currentTimeMillis();
        long tempoDeExecucao = tempofinal - tempoinicial;

        if (resultado == true){
            System.out.println("Encontrou pelo menos um par com diferença T");
        }
        else{
            System.out.println("Não encontrou um par com diferença T");
        }
        System.out.println("\nTempo de execução: " + tempoDeExecucao + "ms" +
                "\nComparações: "       + comparacoes);
        System.out.println();
    }

    public static boolean temParesComDistanciaT(Integer[] array, int T) {
        // Encontra o tamanho do vetor
        int n = array.length;

        // Itera o vetor inteiro
        for (int i = 0; i < n; i++) {
            comparacoes++;
            // Itera o vetor a partir de i+1
            for (int j = i + 1; j < n; j++) {
                comparacoes++;

                //Verifica se há um par com a difereça T
                if (Math.abs(array[i] - array[j]) == T) {
                    comparacoes++;
                    return true; // Encontrou um par com diferença T
                }
            }
        }
        return false; // Não encontrou nenhum par com diferença T
    }

}
