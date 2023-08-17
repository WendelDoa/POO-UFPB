import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class SistemaEngenho {

    private ArrayList<Cliente> clientes;
    private ArrayList<Cachaca> cachacas;

    public SistemaEngenho(ArrayList<Cliente> clientes, ArrayList<Cachaca> cachacas) {
        this.clientes = clientes;
        this.cachacas = cachacas;
    }

    public void cadastraCachaca(String nome, double valor, int ano) throws CachacaJaExisteException {
        for(Cachaca c : cachacas) {
            if (c.getNome().equals(nome)) {
                throw new CachacaJaExisteException("A cachaça "+ nome +" já existe no sistema.");
            }
        }
        Cachaca cachaca = new Cachaca(nome,valor,ano);
        cachacas.add(cachaca);
        Collections.sort(cachacas);
    }

    public double pesquisarCachachaPreco(String nome) {
        for(Cachaca c : cachacas) {
            if(nome.equals(c.getNome())) {
                return c.getValor();
            }
        }
        return 0;
    }

    public int pesquisarCachacaAno(String nome) {
        for(Cachaca c : cachacas) {
            if(nome.equals(c.getNome())) {
                return c.getAno();
            }
        }
        return 0;
    }

    public void cadastraCliente(String nome, double valorConta) {
        Cliente cliente = new Cliente(nome, valorConta);
        clientes.add(cliente);
    }

    public double consultaContaCliente(String nome) {
        for(Cliente c : clientes) {
            if (c.getNome().equals(nome)) {
                return c.getValorConta();
            }
        }
        return 0;
    }

    public void pagarContaCliente(String nome, double valor) {
        for(Cliente c : clientes) {
            if (c.getNome().equals(nome)) {
                c.setValorConta(valor);
            }
        }
    }

    public boolean consultaCachacaEnvelhecida(String nome) {
        for(Cachaca c : cachacas) {
            if (c.getNome().equals(nome)) {
                if (c instanceof CachachaEnvelhecida) {
                    return ((CachachaEnvelhecida) c).getEhEnvelhecida();
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SistemaEngenho that = (SistemaEngenho) o;
        return Objects.equals(clientes, that.clientes) && Objects.equals(cachacas, that.cachacas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientes, cachacas);
    }


}