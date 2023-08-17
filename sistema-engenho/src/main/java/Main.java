import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Cachaca> cachacas = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();
        SistemaEngenho sistema = new SistemaEngenho(clientes, cachacas);

        System.out.println("Quantas cachaças você irá cadastrar?");
        int quantCadastraCachaca = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < quantCadastraCachaca; i++) {

            System.out.println("Digite o nome da cachaça");
            String nome = scanner.nextLine();
            System.out.println("Digite o valor da cachaça");
            double valor = Double.parseDouble(scanner.nextLine());
            System.out.println("Digite o ano da cachaça");
            int ano = Integer.parseInt(scanner.nextLine());

            try {
                sistema.cadastraCachaca(nome, valor, ano);
                System.out.println("\nCachaça cadastrada com sucesso!\n");
            } catch (CachacaJaExisteException e) {
                System.out.println("Erro: "+ e.getMessage());
            }

        }

    }
}
