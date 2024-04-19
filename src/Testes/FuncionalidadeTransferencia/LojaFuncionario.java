package Testes.FuncionalidadeTransferencia;

import Classes.Banco;
import Classes.Cliente;
import Classes.Funcionario;
import Classes.Loja;



public class LojaFuncionario {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Funcionario[] funcionariosLoja1 = {new Funcionario("Funcionario 1", banco), new Funcionario("Funcionario 2", banco)};
        Funcionario[] funcionariosLoja2 = {new Funcionario("Funcionario 3", banco), new Funcionario("Funcionario 4", banco)};

        Loja loja1 = new Loja("Loja 1", banco, funcionariosLoja1);
        Loja loja2 = new Loja("Loja 2", banco, funcionariosLoja2);

        // lojas disponiveis
        Loja[] lojasDisponiveis = {loja1, loja2};

        // Criando e iniciando os clientes
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


        // Aguardando a finalização das threads dos clientes ... antes de pagar os funcionários
        try {
            cliente1.join();
            cliente2.join();
            cliente3.join();
            cliente4.join();
            cliente5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Paga os funcionários após todos os clientes terminarem suas compras
        loja1.pagarFuncionarios();
        loja2.pagarFuncionarios();

        // saldo final lojas e clientes
        System.out.println("Saldo final da conta da " + loja1.getNome() + ": " + loja1.getContaLoja().getSaldo());
        System.out.println("Saldo final da conta da " + loja2.getNome() + ": " + loja2.getContaLoja().getSaldo());

        System.out.println("Saldo final da conta do " + cliente1.getNome() + ": "+ cliente1.getContaCliente().getSaldo() );
        System.out.println("Saldo final da conta do " + cliente2.getNome() + ": "+ cliente2.getContaCliente().getSaldo() );
        System.out.println("Saldo final da conta do " + cliente3.getNome() + ": "+ cliente3.getContaCliente().getSaldo() );
        System.out.println("Saldo final da conta do " + cliente4.getNome() + ": "+ cliente4.getContaCliente().getSaldo() );
        System.out.println("Saldo final da conta do " + cliente5.getNome() + ": "+ cliente5.getContaCliente().getSaldo() );



        // saldos dos funcionários de cada loja
        for (Funcionario funcionario : loja1.getFuncionarios()) {
            System.out.println("Funcionário - Saldo do " + funcionario.getNome() + " da " + loja1.getNome() + ": " + funcionario.getContaSalario().getSaldo());
        }
        for (Funcionario funcionario : loja2.getFuncionarios()) {
            System.out.println("Funcionário - Saldo do " + funcionario.getNome() + " da " + loja2.getNome() + ": " + funcionario.getContaSalario().getSaldo());
        }
    }
}
