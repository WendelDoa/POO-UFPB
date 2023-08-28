package br.ufpb.dcx.amigo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestaAmigo {

    public static void main(String [] args) throws AmigoInexistenteException, AmigoJaExisteException {

        SistemaAmigo sistema = new SistemaAmigo();

        sistema.cadastraAmigo("José", "jose@dcx.ufpb.br");
        sistema.cadastraAmigo("Maria", "maria@dcx.ufpb.br");


        try {
            sistema.configuraAmigoSecretoDe("jose@dcx.ufpb.br", "maria@dcx.ufpb.br");
            sistema.configuraAmigoSecretoDe("maria@dcx.ufpb.br", "jose@dcx.ufpb.br");
        } catch (AmigoInexistenteException e) {
            e.getMessage();
        }

        sistema.enviarMensagemParaAlguem("Oii lindo", "maria@dcx.ufpb.br", "jose@dcx.ufpb.br", true);
        sistema.enviarMensagemParaTodos("Olá para todos", "jose@dcx.ufpb.br", true);

        List<Mensagem> mensagemsAnonimas = sistema.pesquisaMensagensAnonimas();
        for(Mensagem m : mensagemsAnonimas) {
            System.out.println(m.getTextoCompletoAExibir());
        }

        try {
            String amigoSecretoPesquisa = sistema.pesquisaAmigoSecretoDe("jose@dcx.ufpb.br");
            if(amigoSecretoPesquisa.equals("maria@dcx.ufpb.br")) {
                System.out.println("OK");
            }
        } catch (AmigoNaoSorteadoException e) {
            e.getMessage();
        }

    }
}
