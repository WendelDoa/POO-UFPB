package br.ufpb.dcx.amigo;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SistemaAmigo {

    private List<Amigo> amigos;

    public static void main(String[] args) {
        List<Amigo> lista = new LinkedList<>();

        public String pesquisaAmigoSecreto(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
            for (Amigo a : this.amigos)
        }
        lista.add(new Amigo("Ayla", "ayla@dcx.ufpb.br"));
        lista.add(new Amigo("José", "jose@dcx.ufpb.br"));
        lista.add(new Amigo("Maria", "maria@dcx.ufpb.br"));
        lista.add(new Amigo("Carlos", "carlos@dcx.ufpb.br"));

        System.out.println("Lista desordenada:");
        Collections.sort(lista);
        for (Amigo a: lista) {
            System.out.println("Nome"+a.getNome());
        }
    }
}
