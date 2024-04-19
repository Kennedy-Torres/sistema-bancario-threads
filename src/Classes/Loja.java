package Classes;
// RACIOCINIO: cliente -> loja -> funcionario
// loja recebe o saldo(inicio do saldo da loja é zero) do cliente
// o saldo que ela recebe, deposita na sua conta
// loja paga os funcionarios assim que possui saldo de 1400(salarioFuncionario)

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private final String nome;
    private final Conta contaLoja; // fluxo: loja -> funcionario
    private List<Funcionario> funcionarios;
    private Banco banco; // banco tranfere -> origem: loja, destino: funcionario

    public Loja(String nome, Banco banco, Funcionario[] funcionarios) {
        this.nome = nome;
        this.contaLoja = new Conta(nome, 0); // p/ evitar de passar o nome duas vezes ja crio a conta com nome e saldo especifico
        this.banco = banco;
        this.funcionarios = new ArrayList<>();

        // para cada loja criada temos 2 funcionários
        for (int i = 0; i < 2; i++) {
            Funcionario funcionario = new Funcionario("Funcionario "+ (i+1), this.banco);
            this.funcionarios.add(funcionario); //  lista de funcionarios da loja
        }
    }

    // Método para pagar os funcionários quando o saldo da loja for suficiente
    public void pagarFuncionarios() {
        double salarioFuncionario = 1400.0;

        synchronized (contaLoja) { // Controla o acesso concorrente p/ conta da loja
            while (contaLoja.getSaldo() >= salarioFuncionario) {// Verifica se a loja possui saldo suficiente para pagar os salários
                // !!!! o salario eh pago de forma individual
                for (Funcionario funcionario : funcionarios) {
                    if (contaLoja.getSaldo() >= salarioFuncionario) {
                        banco.transferir(contaLoja, funcionario.getContaSalario(), salarioFuncionario);
                        System.out.println("Salário do " + funcionario.getNome() + " da loja " + nome + " pago com sucesso. ( " + funcionario.getContaSalario().getSaldo() + " )");
                    }
                    else {
                        System.out.println("A " + nome + " não possui saldo suficiente para pagar o salário do "+ funcionario.getNome());
                        break;

                    }
                }
            }
        }
    }


    public Conta getContaLoja() {
        return contaLoja;
    }

    public String getNome() {
        return nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
