package Classes;
// RACIOCINIO: cliente -> loja -> funcionario
// loja paga funcionario assim que contaLoja possui 1400
// dos 1400 - 280 vai para contaInvestimento(20%) e 1120 para contaSalario

public class Funcionario extends Thread {
    private String nome; // opcional
    private Conta contaSalario;
    private Conta contaInvestimento;


    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getContaInvestimento() {
        return contaInvestimento;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
}

