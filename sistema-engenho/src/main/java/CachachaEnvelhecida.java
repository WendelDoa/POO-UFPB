public class CachachaEnvelhecida extends Cachaca {

    private boolean ehEnvelhecida;

    public CachachaEnvelhecida(String nome, double valor, int ano, boolean ehEnvelhecida) {
        super(nome, valor, ano);
        this.ehEnvelhecida = ehEnvelhecida;
    }

    public boolean getEhEnvelhecida() {
        return ehEnvelhecida;
    }

    public void setEhEnvelhecida(boolean ehEnvelhecida) {
        this.ehEnvelhecida = ehEnvelhecida;
    }


}
