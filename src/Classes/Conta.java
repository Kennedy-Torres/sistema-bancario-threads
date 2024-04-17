package Classes;

// cliente possui conta com saldoInicial = 1000
// loja inicia com saldo zero
// loja tem conta para receber pagamento dos clientes
public class Conta {
    private double saldo;

    // Ao invés de setSaldo(), adotei um construtor para definir o saldo inicial da conta
    public Conta(double saldoInicial){
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    // usando metodo debitar e creditar para modularizar o código, maior conscistência de dados na hora de usar metodo tranferir na classe Banco
    // uso do synchronized individualizado(em debitar e creditar) para evitar acesso simultaneo das threads add e removendo dinheiro da mesma conta
    public synchronized void debitar(double valor) {
        saldo -= valor;
    }
    public synchronized void creditar(double valor) {
        saldo += valor;
    }

}
