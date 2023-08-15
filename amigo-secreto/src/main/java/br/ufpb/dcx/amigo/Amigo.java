package br.ufpb.dcx.amigo;

import java.util.Objects;

public class Amigo implements Comparable<Amigo> {

    private String nome;
    private String email;
    private String emailAmigoSorteado;

    public Amigo(String nomeAmigo, String emailAmigo) {
        this.nome = nomeAmigo;
        this.email = emailAmigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nomeRecebido) {
        this.nome = nomeRecebido;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmailAmigoSorteado() {
        return emailAmigoSorteado;
    }

    public void setEmailAmigoSorteado(String emailAmigoRecebido) {
        this.emailAmigoSorteado = emailAmigoRecebido;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amigo amigo = (Amigo) o;

        if (!Objects.equals(nome, amigo.nome)) return false;
        if (!Objects.equals(email, amigo.email)) return false;
        return Objects.equals(emailAmigoSorteado, amigo.emailAmigoSorteado);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (emailAmigoSorteado != null ? emailAmigoSorteado.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Amigo o) {
        return this.nome.compareTo(o.getNome());
    }
}
