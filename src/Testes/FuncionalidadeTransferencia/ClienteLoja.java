package Testes.FuncionalidadeTransferencia;

import Classes.Banco;
import Classes.Cliente;
import Classes.Loja;

// Testando a funcionalidade:
// CAda cliente deve realizar compras, de R$ 100,00 ou R$ 200,00, alternando as lojas,
// até o saldo da conta estar vazio.

public class ClienteLoja {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Loja loja1 = new Loja("Loja 1", /*contaLoja1,*/ banco);
        Loja loja2 = new Loja("Loja 2", /*contaLoja2,*/ banco);


        // Criando os array de lojas disponíveis
        Loja[] lojasDisponiveis = {loja1, loja2};

        // Criando e iniciando os clientes
        Cliente cliente1 = new Cliente("cliente 1",/*contaCliente1,*/ lojasDisponiveis, banco);
        Cliente cliente2 = new Cliente("cliente 2",/*contaCliente2,*/ lojasDisponiveis, banco);
        Cliente cliente3 = new Cliente("cliente 3",/*contaCliente2,*/ lojasDisponiveis, banco);
        Cliente cliente4 = new Cliente("cliente 4",/*contaCliente2,*/ lojasDisponiveis, banco);
        Cliente cliente5 = new Cliente("cliente 5",/*contaCliente2,*/ lojasDisponiveis, banco);
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();

        // Aguardando a finalização das threads dos clientes
        try {
            cliente1.join();
            cliente2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // saldo final das contas das lojas e clientes
        System.out.println("Saldo final da conta da " + loja1.getNome() + ": " + loja1.getContaLoja().getSaldo());
        System.out.println("Saldo final da conta da " + loja2.getNome() + ": " + loja2.getContaLoja().getSaldo());
        System.out.println("Saldo final da conta do " + cliente1.getNome() + ": "+ cliente1.getContaCliente().getSaldo() );
        System.out.println("Saldo final da conta do " + cliente2.getNome() + ": "+ cliente2.getContaCliente().getSaldo() );
        System.out.println("Saldo final da conta do " + cliente3.getNome() + ": "+ cliente3.getContaCliente().getSaldo() );
        System.out.println("Saldo final da conta do " + cliente4.getNome() + ": "+ cliente4.getContaCliente().getSaldo() );
        System.out.println("Saldo final da conta do " + cliente5.getNome() + ": "+ cliente5.getContaCliente().getSaldo() );
    }
}
