package br.ufpb.dcx.amigo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SistemaAmigo {

    private List<Amigo> amigos;
    private List<Mensagem> mensagens;

    public SistemaAmigo() {
        this.amigos = new ArrayList<>();
        this.mensagens = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
        for(Amigo a : amigos) {
            if(a.getEmail().equals(emailAmigo)) {
                throw new AmigoJaExisteException("Amigo já existe!");
            }
        }
        Amigo amigo = new Amigo(nomeAmigo, emailAmigo);
        amigos.add(amigo);
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        for(Amigo a : amigos) {
            if(a.getEmail().equals(emailAmigo)) {
                return a;
            }
        }
        throw new AmigoInexistenteException("Amigo não encontrado!");
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        Mensagem mensagem = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        mensagens.add(mensagem);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        Mensagem mensagem = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        mensagens.add(mensagem);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for (Mensagem m : mensagens) {
            if(m.ehAnonima()) {
                mensagensAnonimas.add(m);
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        for(Amigo a : amigos) {
            if (a.getEmail().equals(emailDaPessoa)) {
                a.setEmailAmigoSorteado(emailAmigoSorteado);
                return;
            }
        }
        throw new AmigoInexistenteException("Amigo não encontrado");
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        for (Amigo a : this.amigos) {
            if (a.getEmail().equals(emailDaPessoa)) {
                if (a.getEmailAmigoSorteado() == null) {
                    throw new AmigoNaoSorteadoException("Não foi sorteado o amigo de" + emailDaPessoa);
                } else {
                    return a.getEmailAmigoSorteado();
                }
            }
        }
        throw new AmigoInexistenteException("Não foi encontrado no sistema ninguém com o email " + emailDaPessoa);
    }
}