package br.ufpb.dcx.amigo;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class TestaSistemaAmigoGUI {

    public static void main(String[] args) throws AmigoJaExisteException {

        Scanner scanner = new Scanner(System.in);
        SistemaAmigo sistema = new SistemaAmigo();

        System.out.print("Digite a quantidade de amigos que vão participar da brincadeira: ");
        int quantAmigos = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < quantAmigos; i++) {

            System.out.println("Digite o nome: ");
            String nome = scanner.nextLine().toLowerCase();
            System.out.println("Digite o email: ");
            String email = scanner.nextLine().toLowerCase();
            sistema.cadastraAmigo(nome, email);
        }
        try {
            sistema.configuraAmigoSecretoDe("jose@dcx.ufpb.br", "maria@dcx.ufpb.br");
            sistema.configuraAmigoSecretoDe("maria@dcx.ufpb.br","jose@dcx.ufpb.br");
        } catch (AmigoInexistenteException e) {
            e.getMessage();
        }

        List<Amigo> amigosSorteio = new ArrayList<>();
        Collections.shuffle(amigosSorteio);

        for(int i = 0; i < quantAmigos; i++) {

            Amigo amigo1 = amigosSorteio.get(i);
            Amigo amigo2 = amigosSorteio.get((i+1) % quantAmigos);

            try {
                sistema.configuraAmigoSecretoDe(amigo1.getEmail(),amigo2.getEmail());
            } catch (AmigoInexistenteException e) {
                e.getMessage();
            }

            System.out.println("A pessoa "+amigo1.getNome()+" tirou "+amigo2.getNome()+" como amigo sorteado.");

        }

        System.out.println("Digite o seu nome para enviar uma mensagem");
        String nome = scanner.nextLine().toLowerCase();

        System.out.println("É anonima ou não? ");
        String cond1 = scanner.nextLine().toUpperCase();

        System.out.println("Digite seu texto abaixo");
        String texto = scanner.nextLine();

        System.out.println("É para todos ou para alguem?");
        String cond2 = scanner.nextLine().toUpperCase();

        String emailRemetente = null;

        boolean ehAnonima;
        if (cond1.equals("SIM")) {
            ehAnonima = true;
        } else {
            ehAnonima = false;
        }

        if(cond2.equals("TODOS")) {
            sistema.enviarMensagemParaTodos(texto, emailRemetente, ehAnonima);

        } else {
            System.out.println("Digite o email do destinatario");
            String emailDestinatario = scanner.nextLine().toLowerCase();
            sistema.enviarMensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        }

        for(Mensagem m : sistema.pesquisaTodasAsMensagens()) {
            System.out.println("Todas as mensagens abaixo");
            System.out.println(m.getTextoCompletoAExibir());
        }

    }
}
//end