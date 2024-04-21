package Classes;
// Fluxo saldo: cliente -> loja -> funcionario
// loja paga funcionario assim que contaLoja possui 1400
// Usar o lock -> dos 1400 - 280 vai para contaInvestimento(20%) e 1120 para contaSalario

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Funcionario extends Thread {
    private String nome;
    private Loja loja;
    private Conta contaSalario;
    private Conta contaInvestimento;
    private Banco banco;
    private final Lock lock = new ReentrantLock(); // Lock para garantir exclusão mutua durante a transferência


    public Funcionario(String nome,Loja loja, Banco banco) {
        this.nome = nome;
        this.loja = loja;
        this.contaSalario = new Conta(nome + " - Salário",0);
        this.contaInvestimento = new Conta(nome + " - Investimento",0);
        this.banco = banco;

    }

    @Override
    public void run() {
        receberSalario();
        DeContaSalarioParaContaInvestimento();
    }

    private void receberSalario() {
        double salario = 1400.0;
        lock.lock();
            try{
                synchronized (loja) { // sincronizei objeto loja para evitar surpresas de condições adversas geradas no metodo transferir()
                    if (loja.getContaLoja().getSaldo() >= salario) {
                        banco.transferir(loja.getContaLoja(), getContaSalario(), salario);
                        System.out.println("Salário de " + nome + " pago pela " + loja.getNome() + ". Conta de "+nome+" (antes do investimento): R$" + getContaSalario().getSaldo());
                    } else {
                        System.out.println("A " + loja.getNome() + " não possui saldo suficiente para pagar o salário de " + getNome() + ". (Saldo atual da " + loja.getNome() + ": R$" + loja.getContaLoja().getSaldo()+")");
                    }
                }
            }finally {
                lock.unlock();
            }
    }

    // metodo para transferir saldo entre as contas do funcionario... fluxo: contaSalario -> contaInvestimento
    public void DeContaSalarioParaContaInvestimento() {
        lock.lock(); // garante exclusão mútua durante a transferência
        try {
            double valorInvestimento = getContaSalario().getSaldo() * 0.2; // investe 20% do salario que a loja deu p/ Funcionario
            if (valorInvestimento == 0 ){
                System.out.println("Funcionario - " + nome + " não possui saldo suficiente para investir.");
            }else{
                banco.transferir(contaSalario, contaInvestimento, valorInvestimento);
                System.out.println("\n(Funcionário) - " + nome + " investiu R$" + valorInvestimento+", Saldo atualizado:\n- Conta de investimento = R$"+getContaInvestimento().getSaldo()+" e Conta do salario(líquido) = R$"+getContaSalario().getSaldo());
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

