package service;

import java.util.Random;

public class gerenciarVetor {

    public class GeradorDeVetor {

        public static Integer[] gerarVetorInteiro(int n) {
            int limite = 99999; // Tamanho máximo que os itens no vetor podem chegar
            Random random = new Random();
            Integer[] vetor = new Integer[n];
            for (int i = 0; i < n; i++) {
                vetor[i] = random.nextInt(limite + 1); // Gera números inteiros no intervalo [0, limite]
            }
            return vetor;
        }

        public static Double[] gerarVetorDouble(int n) {
            double limite = 99999.0;  // Tamanho máximo que os itens no vetor podem chegar
            Random random = new Random();
            Double[] vetor = new Double[n];
            for (int i = 0; i < n; i++) {
                vetor[i] = random.nextDouble() * limite; // Gera números double no intervalo [0, limite]
            }
            return vetor;
        }

        public static String[] gerarVetorString(int n) {
            int comprimento = 5;  // Tamanho dos itens no vetor
            Random random = new Random();
            String[] vetor = new String[n];
            String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            for (int i = 0; i < n; i++) {
                StringBuilder strBuilder = new StringBuilder();
                for (int j = 0; j < comprimento; j++) {
                    char caractere = caracteres.charAt(random.nextInt(caracteres.length())); // Gera caracteres com o comprimento dado
                    strBuilder.append(caractere);
                }
                vetor[i] = strBuilder.toString();
            }
            return vetor;
        }

        public static int[] gerarVetorTamanhoAleatorio(int tamanhoMaximo, int elementoDeMaiorValor) {
            Random rand = new Random();
            int tamanho = rand.nextInt(tamanhoMaximo) + 1; // Gera um tamanho aleatório entre 1 e tamanhoMaximo
            int[] vetor = new int[tamanho];

            for (int i = 0; i < tamanho; i++) {
                int elemento;
                do {
                    elemento = rand.nextInt(elementoDeMaiorValor + 1); // Gera um valor aleatório entre 0 e elementoDeMaiorValor
                } while (elemento == 0); // Verifica se o elemento é igual a zero e gera novamente se for

                vetor[i] = elemento;
            }

            return vetor;
        }
    }
}
