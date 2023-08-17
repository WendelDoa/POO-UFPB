public class Cliente implements Comparable<Cliente> {

    private String nome;
    private Double valorConta;

    public Cliente(String nome, double valorConta) {
        this.nome = nome;
        this.valorConta = valorConta;
   }

   public String getNome() {
        return nome;
   }

   public void setNome(String nome) {
        this.nome = nome;
   }

   public Double getValorConta() {
        return valorConta;
   }

   public void setValorConta(Double valorConta) {
        this.valorConta = valorConta;
   }

   public int compareTo(Cliente outroCliente) {
        return this.nome.compareTo(outroCliente.nome);
   }

}
