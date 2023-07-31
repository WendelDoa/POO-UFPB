package br.ufpb.dcx.amigo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestaAmigo {

    public static void main(String [] args){
        List<Amigo> lista = new LinkedList<>();
        lista.add(new Amigo("Zulmira", "zulmira@dcx.ufpb.br"));
        lista.add(new Amigo("José", "jose@dcx.ufpb.br"));
        lista.add(new Amigo("Maria", "maria@dcx.ufpb.br"));
        lista.add(new Amigo("Carlos", "carlos@dcx.ufpb.br"));
        System.out.println("Lista desordenada:");
        for (Amigo a: lista){
            System.out.println("Nome:"+a.getNome());
        }

        System.out.println("Lista ORDENADA:");
        Collections.sort(lista);
        for (Amigo a: lista){
            System.out.println("Nome:"+a.getNome());
        }
    }
}
