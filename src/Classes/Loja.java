package Classes;
// RACIOCINIO: cliente -> loja -> funcionario
// loja recebe o saldo(inicio do saldo da loja é zero) do cliente
// o saldo que ela recebe, deposita na contaLoja
// loja paga os funcionarios assim que possui saldo de 1400(salarioFuncionario)


public class Loja {
    private final String nome;
    private final Conta contaLoja;

    public Loja(String nome) {
        this.nome = nome;
        this.contaLoja = new Conta(nome, 0); // p/ evitar de passar o nome duas vezes ja crio a conta com nome e saldo especifico
    }

    public Conta getContaLoja() {
        return contaLoja;
    }

    public String getNome() {
        return nome;
    }

}
