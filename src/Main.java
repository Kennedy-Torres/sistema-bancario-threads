import Classes.Banco;
import Classes.Funcionario;
import Classes.Loja;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Loja loja1 = new Loja("Loja 1");
        Loja loja2 = new Loja("Loja 2");

        // lojas disponiveis
        Loja[] lojasDisponiveis = {loja1, loja2};

        Funcionario funcionario1 = new Funcionario("Amanda", loja1, banco);
        Funcionario funcionario2 = new Funcionario("Yasmin", loja1, banco);
        Funcionario funcionario3 = new Funcionario("José", loja2, banco);
        Funcionario funcionario4 = new Funcionario("Marcos", loja2, banco);

        // lista de funcionarios da loja1
        List<Funcionario> funcionariosLoja1 = new ArrayList<>();
        funcionariosLoja1.add(funcionario1);
        funcionariosLoja1.add(funcionario2);

        // lista de funcionarios da loja2
        List<Funcionario> funcionariosLoja2 = new ArrayList<>();
        funcionariosLoja2.add(funcionario3);
        funcionariosLoja2.add(funcionario4);

    }
}