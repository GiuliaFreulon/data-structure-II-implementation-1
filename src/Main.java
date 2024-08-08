import java.util.Scanner;
import service.*;

//DISCIPLINA: ESTRUTURA DE DADOS II PRIMEIRA ATIVIDADE PRATICA
//ALUNAS:
//Giulia de Araujo Freulon
//Juliana Camara

public class Main {

    public static void main(String[] args) {

        int tamanho = 0;
        Scanner input = new Scanner(System.in);
        boolean loopMain = true;

        while(loopMain) {
            System.out.println("Selecione uma opção a seguir:\n"+
                    " 1 - 1ª Questão\n" +
                    " 2 - 2ª Questão\n" +
                    " 3 - 3ª Questão\n" +
                    " 4 - 4ª Questão\n" +
                    " 5 - Sair");

            int userInput = input.nextInt();

            switch (userInput) {
                case 1 -> {
                    System.out.println(
                            " 1 - Vetor Pequeno  (1.000)\n" +
                            " 2 - Vetor Médio    (100.000)\n" +
                            " 3 - Vetor Grande   (1.000.000)\n");

                    int userInput00 = input.nextInt();

                    switch (userInput00) {
                        case 1 -> {
                            tamanho = 1000;
                        }
                        case 2 -> {
                            tamanho = 100000;
                        }
                        case 3 -> {
                            tamanho = 1000000;
                        }
                        default -> {
                            System.out.println("Insira um valor válido\n");
                            loopMain = false;
                        }
                    }


                    System.out.println(
                            " 1 - Encontrar Maiores Inteiros\n" +
                            " 2 - Encontrar Maiores Doubles\n" +
                            " 3 - Encontrar Maiores Strings\n");

                    int userInput01 = input.nextInt();

                    switch (userInput01) {
                        case 1 -> {
                            primeiraquestao.inteiro(tamanho);
                        }
                        case 2 -> {
                            primeiraquestao.racional(tamanho);
                        }
                        case 3 -> {
                            primeiraquestao.string(tamanho);
                        }
                        default -> {
                            System.out.println("Insira um valor válido\n");
                            loopMain = false;
                        }
                    }
                }

                case 2 -> {
                    System.out.println(
                            " 1 - Vetor Pequeno  (1.000)\n" +
                            " 2 - Vetor Médio    (100.000)\n" +
                            " 3 - Vetor Grande   (1.000.000)\n");

                    int userInput0 = input.nextInt();

                    switch (userInput0) {
                        case 1 -> {
                            tamanho = 1000;
                        }
                        case 2 -> {
                            tamanho = 100000;
                        }
                        case 3 -> {
                            tamanho = 1000000;
                        }
                        default -> {
                            System.out.println("Insira um valor válido\n");
                            loopMain = false;
                        }
                    }


                    System.out.println(
                            " 1 - Encontrar Mediana de Inteiros\n" +
                            " 2 - Encontrar Mediana de Doubles\n" +
                            " 3 - Encontrar Mediana de Strings\n");

                    int userInput1 = input.nextInt();

                    switch (userInput1) {
                        case 1 -> {
                            segundaquestao.inteiro(tamanho);
                        }
                        case 2 -> {
                            segundaquestao.racional(tamanho);
                        }
                        case 3 -> {
                            segundaquestao.string(tamanho);
                        }
                        default -> {
                            System.out.println("Insira um valor válido\n");
                            loopMain = false;
                        }
                    }
                }


                case 3 -> {
                    System.out.println(
                            " 1 - Vetor Pequeno  (1.000)\n" +
                            " 2 - Vetor Médio    (100.000)\n" +
                            " 3 - Vetor Grande   (1.000.000)\n");

                    int userInput0 = input.nextInt();

                    switch (userInput0) {
                        case 1 -> {
                            tamanho = 1000;
                        }
                        case 2 -> {
                            tamanho = 100000;
                        }
                        case 3 -> {
                            tamanho = 1000000;
                        }
                        default -> {
                            System.out.println("Insira um valor válido\n");
                            loopMain = false;
                        }
                    }

                    System.out.println(
                            " 1 - Letra A\n" +
                            " 2 - Letra B\n");

                    int userInput2 = input.nextInt();

                    switch (userInput2) {
                        case 1 -> {
                            terceiraquestaoA.inteiro(tamanho);
                        }
                        case 2 -> {
                            terceiraquestaoB.inteiro(tamanho);
                        }
                        default -> {
                            System.out.println("Insira um valor válido\n");
                            loopMain = false;
                        }
                    }
                }

                case 4 -> {
                    System.out.println(
                            " 1 - Vetor Pequeno  (1.000)\n" +
                            " 2 - Vetor Médio    (10.000)\n" +
                            " 3 - Vetor Grande   (100.000)\n");


                    int userInput02 = input.nextInt();

                    switch (userInput02) {
                        case 1 -> {
                            tamanho = 1000;
                        }
                        case 2 -> {
                            tamanho = 10000;
                        }
                        case 3 -> {
                            tamanho = 100000;
                        }
                        default -> {
                            System.out.println("Insira um valor válido\n");
                            loopMain = false;
                        }
                    }


                    System.out.println(
                            " 1 - BHSISort de Inteiros\n" +
                            " 2 - BHSISort de Doubles\n" +
                            " 3 - BHSISort de Strings\n");

                    int userInput03 = input.nextInt();

                    switch (userInput03) {
                        case 1 -> {
                            quartaquestao.inteiro(tamanho);
                        }
                        case 2 -> {
                            quartaquestao.racional(tamanho);
                        }
                        case 3 -> {
                            quartaquestao.string(tamanho);
                        }
                        default -> {
                            System.out.println("Insira um valor válido\n");
                            loopMain = false;
                        }
                    }
                }

                case 5 -> loopMain = false;

                default -> System.out.println("Insira um valor válido\n");
            }
        }
    }

}
