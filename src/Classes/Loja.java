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
