package br.ufpb.dcx.amigo;
import java.util.List;

public class SistemaAmigo {

    private List<Amigo> amigos;

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        for (Amigo a : this.amigos) {
            if (a.getEmail().equals(emailDaPessoa)) {
                String emailAmigoSorteado = a.getEmailAmigoSorteado();
                if (emailAmigoSorteado == null) {
                    throw new AmigoInexistenteException("Não foi sorteado o amigo de" + emailDaPessoa);
                } else {
                    return emailAmigoSorteado;
                }
            }
        }
        throw new AmigoInexistenteException("Não foi encontrado no sistema ninguém com o email " + emailDaPessoa);
    }
}