import java.util.Objects;

public class Cachaca implements Comparable<Cachaca> {

    private String nome;
    private double valor;
    private int ano;

    public Cachaca(String nome, double valor, int ano) {
        this.nome = nome;
        this.valor = valor;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor -= valor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public int compareTo(Cachaca outraCachaca) {
        return this.nome.compareTo(outraCachaca.nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cachaca cachaca = (Cachaca) o;
        return Double.compare(valor, cachaca.valor) == 0 && ano == cachaca.ano && Objects.equals(nome, cachaca.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, valor, ano);
    }
}
