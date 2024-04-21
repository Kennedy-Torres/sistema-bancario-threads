package Classes;

// principal papel dele vai ser a transferencia do saldo evitando paralelismo entre threads
// solução: synchronized no metodo de tranferencia
public class Banco {


    // tranferir dinheiro entre as contas evitando paralelismo entre threads
    public synchronized void transferir(Conta origem, Conta destino, double valor) {
        // Verifica se há saldo suficiente na conta de origem, true -> tranfere ; false
        if (origem.getSaldo() >= valor) {
            origem.debitar(valor);
            destino.creditar(valor);
        } else { // pode retirar, o saldo nunca sera insuficiente, devido a logica nas classes isoladas
            System.out.println("Transferência de " + valor + " não pôde ser concluída: saldo insuficiente em " + origem.getNome());
        }

        // espera 0,1s antes de realizar a próxima transacao
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
