import Classes.Banco;
import Classes.Cliente;
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



        // instânciando os clientes e dando start nas threads
        Cliente cliente1 = new Cliente("cliente 1", lojasDisponiveis, banco);
        Cliente cliente2 = new Cliente("cliente 2", lojasDisponiveis, banco);
        Cliente cliente3 = new Cliente("cliente 3", lojasDisponiveis, banco);
        Cliente cliente4 = new Cliente("cliente 4", lojasDisponiveis, banco);
        Cliente cliente5 = new Cliente("cliente 5", lojasDisponiveis, banco);
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();


        // espera a finalização das threads dos clientes antes de startar os funcionários
        try {
            cliente1.join();
            cliente2.join();
            cliente3.join();
            cliente4.join();
            cliente5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Startar as threads Funcionário após todas as threads Cliente terminarem
        System.out.println("=======================================================================================");
        System.out.println("|| (Thread Funcionarios) - Pagamento(Loja->Funcionário) e Investimento(Funcionário)  ||");
        System.out.println("=======================================================================================\n");
        funcionario1.start();
        funcionario2.start();
        funcionario3.start();
        funcionario4.start();


        // só é possivel fornecer os valores corretos após todas as threads de funcionários terminarem
        // Aguardando a finalização das threads dos funcionarios ...
        try{
            funcionario1.join();
            funcionario2.join();
            funcionario3.join();
            funcionario4.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}