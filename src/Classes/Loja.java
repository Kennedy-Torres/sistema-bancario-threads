package Classes;
// RACIOCINIO: cliente -> loja -> funcionario
// loja recebe o saldo(inicio do saldo da loja é zero) do cliente
// o saldo que ela recebe, deposita na sua conta
// loja paga os funcionarios assim que possui saldo de 1400(salarioFuncionario)

public class Loja {
    private final String nome;
    private final Conta contaLoja; // loja tem que ter funcionario... fluxo: loja -> funcionario
    private Banco banco; // banco tranfere -> origem: loja, destino: funcionario

    public Loja(String nome, Banco banco) {
        this.nome = nome;
        this.contaLoja = new Conta(nome, 0); // p/ evitar de passar o nome duas vezes ja crio a conta com nome e saldo especifico
        this.banco = banco;
    }

    public Conta getContaLoja() {
        return contaLoja;
    }

    public String getNome() {
        return nome;
    }
}
