package br.ufpb.dcx.amigo;

public class MensagemParaAlguem extends Mensagem {

    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinario) {
        this.emailDestinatario = emailDestinario;
    }

    @Override
    public String getTextoCompletoAExibir() {
        if(super.ehAnonima()) {
            return "Mensagem para: " + getEmailDestinatario() + ". Texto: " + super.getTexto();
        } else {
            return "Mensagem de: " + super.getEmailRemetente() + ". Para: " + this.getEmailDestinatario() +". Texto: " + super.getTexto();
        }
    }
}