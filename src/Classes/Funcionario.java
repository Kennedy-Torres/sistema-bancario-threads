package Classes;
// Fluxo saldo: cliente -> loja -> funcionario
// loja paga funcionario assim que contaLoja possui 1400
// Usar o lock -> dos 1400 - 280 vai para contaInvestimento(20%) e 1120 para contaSalario

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Funcionario extends Thread {
    private String nome;
    private Conta contaSalario;
    private Conta contaInvestimento;
    private Banco banco;
    private final Lock lock = new ReentrantLock(); // Lock para garantir exclusão mutua durante a transferência


    public Funcionario(String nome, Banco banco) {
        this.nome = nome;
        this.contaSalario = new Conta(nome + " - Salário",0);
        this.contaInvestimento = new Conta(nome + " - Investimento",0);
        this.banco = banco;
    }

    @Override
    public void run() {

        DeContaSalarioParaContaInvestimento();
    }

    // Método para transferir saldo entre as contas do funcionario... fluxo-> contaSalario -> contaInvestimento
    public void DeContaSalarioParaContaInvestimento() {
        lock.lock(); //  o lock  garante a exclusão mútua durante a transferência
        try {
            double valorInvestimento = getContaSalario().getSaldo() * 0.2; // investe 20% do salario que a loja deu p/ Funcionario
            if (valorInvestimento == 0 ){
                System.out.println("Funcionario -" + nome + " não possui saldo suficiente para investir.");
            }else{
                banco.transferir(contaSalario, contaInvestimento, valorInvestimento);
                System.out.println("Funcionário - " + nome + " investiu R$" + valorInvestimento + " em sua conta de investimento");
            }
        } finally {
            lock.unlock();
        }
    }




    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getContaInvestimento() {
        return contaInvestimento;
    }


    public String getNome() {
        return nome;
    }
}

