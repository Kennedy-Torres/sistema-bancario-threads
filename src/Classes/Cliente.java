package Classes;
// RACIOCINIO: cliente -> loja -> funcionario
// cliente tem conta com saldo (Inicial de 1000)
// cliente gasta todoo o dinheiro(comprando nas lojas) até zerar saldo ... logica-> cliente só para de comprar quando saldo é zero

public class Cliente extends Thread {
    private String nome; // opcional
    private Conta contaCliente;


    public Conta getContaCliente() {
        return contaCliente;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
}
