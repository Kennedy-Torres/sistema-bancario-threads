package Classes;
// RACIOCINIO: cliente -> loja -> funcionario
// cliente tem conta com saldo (Inicial de 1000)
// cliente gasta todoo o dinheiro(comprando nas lojas) até zerar saldo ... logica-> cliente só para de comprar quando saldo é zero

import java.util.Random;

public class Cliente extends Thread {
    private String nome;
    private Conta contaCliente;
    private Loja[] lojas;
    private Loja ultimaLojaEscolhida; // usado para alterar entre as lojas
    private Banco banco;

    public Cliente(String nome,Loja[] lojas, Banco banco) {
        this.nome = nome;
        this.contaCliente = new Conta(nome, 1000); // p/ evitar de passar o nome duas vezes ja crio a conta com nome e saldo especifico
        this.lojas = lojas;
        this.banco = banco;
    }

    public void run() {
        Random random = new Random();
        while (contaCliente.getSaldo() > 0) {
            // Escolhe aleatoriamente entre R$ 100,00 ou R$ 200,00
            double valorCompra = random.nextDouble() < 0.5 ? 100.0 : 200.0;

            // Escolhe a 1a loja de forma random e a partir dai alterna entre as lojas
            Loja primeiraLojaEscolhida;
            do{
                int indiceLoja = random.nextInt(lojas.length);
                primeiraLojaEscolhida = lojas[indiceLoja];
            }while(primeiraLojaEscolhida == ultimaLojaEscolhida); // condicao para proporcionar alternancia na escolha das lojas
            ultimaLojaEscolhida = primeiraLojaEscolhida; // update

            // Se o saldo for exatamente R$ 100,00 e a compra for de R$ 200,00, ajusta a compra para R$ 100,00}
            if (contaCliente.getSaldo() == 100.0 && valorCompra == 200.0) {
                valorCompra = 100.0;
            }


            // Transfere o valor da compra para a conta da loja ... fluxo: cliente -> loja
            synchronized (this) {
                banco.transferir(contaCliente, ultimaLojaEscolhida.getContaLoja(), valorCompra);
                System.out.println(getThreadName() +" - "+contaCliente.getNome()+ " realizou uma compra de R$" + valorCompra + " na " + ultimaLojaEscolhida.getNome() + " Saldo atual: "+ getContaCliente().getSaldo());
            }

        }
        System.out.println(getThreadName() + " terminou suas compras.");
    }


    public Conta getContaCliente() {
        return contaCliente;
    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }

    public String getNome() {
        return nome;
    }
}
