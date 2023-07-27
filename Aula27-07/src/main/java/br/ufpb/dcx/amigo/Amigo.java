package br.ufpb.dcx.amigo;

import java.util.Objects;

public class Amigo implements Comparable<Amigo> {

    private String nome;
    private String email;
    private String emailAmigoSorteado;

    public Amigo(String nomeAmigo, String emailAmigo) {
        this.nome = nomeAmigo;
        this.emailAmigoSorteado = emailAmigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nomeRecebido) {
        this.nome = nomeRecebido;
    }

    public String getEmailAmigoSorteado() {
        return emailAmigoSorteado;
    }

    public void setEmailAmigoSorteado(String emailAmigoRecebido) {
        this.emailAmigoSorteado = emailAmigoRecebido;
    }


    @Override
    public int compareTo(Amigo o) {
        return this.nome.compareTo(o.getNome());
    }
}
