package br.ufpb.dcx.amigo;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class TestaSistemaAmigoGUI {

    public static void main(String[] args) {

        List<Amigo> amigos = new ArrayList<>();
        List<Mensagem> mensagens = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        SistemaAmigo sistema = new SistemaAmigo(amigos, mensagens);

        System.out.print("Digite a quantidade de amigos que vão participar da brincadeira: ");
        int quantAmigos = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < quantAmigos; i++) {

            System.out.println("Digite o nome: ");
            String nome = scanner.nextLine().toLowerCase();
            System.out.println("Digite o email: ");
            String email = scanner.nextLine().toLowerCase();
            Amigo amigo = new Amigo(nome, email);
            sistema.cadastraAmigo(nome, email);
            amigos.add(amigo);
        }

        List<Amigo> amigosSorteio = new ArrayList<>(amigos);
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
        for(Amigo a : amigos) {
            if(nome.equals(a.getNome())) {
                emailRemetente = a.getEmail();
            }
        }

        boolean ehAnonima;
        if (cond1.equals("SIM")) {
            ehAnonima = true;
        } else {
            ehAnonima = false;
        }

        if(cond2.equals("TODOS")) {
            sistema.enviarMensagemParaTodos(texto, emailRemetente, ehAnonima);
        } else {
            System.out.println("Digite o nome do destinatario");
            String nomeDestinatario = scanner.nextLine().toLowerCase();
            String emailDestinatario = null;
            for(Amigo a : amigos) {
                if(nomeDestinatario.equals(a.getNome())) {
                    emailDestinatario = a.getEmail();
                }
            }
            sistema.enviarMensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        }

        mensagens = sistema.pesquisaTodasAsMensagens();
        for(Mensagem m : mensagens) {
            System.out.println("Todas as mensagens abaixo");
            System.out.println(m.getTextoCompletoAExibir());
        }

    }
}
