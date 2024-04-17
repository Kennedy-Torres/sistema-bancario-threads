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
            System.out.println("Transferência de " + valor + " realizada com sucesso de " + origem + " para " + destino);

        } else {
            System.out.println("Transferência de " + valor + " não pôde ser concluída: saldo insuficiente em " + origem);
        }
    }
}
