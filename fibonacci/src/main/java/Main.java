import java.util.Scanner;

public class Main {

    public static void fib1(int num) {

        int num1 = 0;
        int num2 = 1;

        System.out.printf(num1+","+num2);

        for(int i = 2; i < num; i++) {

            int soma = num1+num2;
            System.out.printf(","+soma);

            num1 = num2;
            num2 = soma;
        }
    }

    public static void fib2(int num) {
        int num1 = 0;
        int num2 = 1;

        System.out.printf(num1+","+num2);

        int i = 2;
        while (i < num) {

            int soma = num1+num2;
            System.out.printf(","+soma);

            num1 = num2;
            num2 = soma;

            i++;
        }
    }

    public static int fib3(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1 || num == 2) {
            return 1;
        }
        return fib3(num-1) +fib3(num-2);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de termos da sequência de Fibonacci: ");
        int numeroInteiro = scanner.nextInt();
        System.out.print("[1] - For\n[2] - While\n[3] - Recursivo\nDigite qual método você quer utilizar: ");
        int numeroEscolha = scanner.nextInt();
        switch(numeroEscolha) {
            case 1:
                fib1(numeroInteiro);
                break;
            case 2:
                fib2(numeroInteiro);
                break;
            case 3:
                for (int i = 0; i < numeroInteiro; i++) {
                    System.out.print(fib3(i) + " ");
                }
                break;
        }
    }

}