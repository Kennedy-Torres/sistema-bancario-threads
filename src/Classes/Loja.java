package Classes;
// RACIOCINIO: cliente -> loja -> funcionario
// loja recebe o saldo(inicio do saldo da loja é zero) do cliente
// o saldo que ela recebe, deposita na sua conta
// loja paga os funcionarios assim que possui saldo de 1400(salarioFuncionario)

public class Loja {
    private String nome; // opcional
    private Conta contaLoja;


    public Conta getContaLoja() {
        return contaLoja;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
}
