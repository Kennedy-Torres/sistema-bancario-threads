# Projeto 1 (AT2/N1) - Sistema Bancário utilizando Threads

![Badge Finalizado]([http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge](https://img.shields.io/static/v1?label=STATUS&message=%20FINALIZADO&color=GREEN&style=for-the-badge))


## Índice 

- [Funcionalidades implantadas no projeto](#hammer-funcionalidades-implantadas-no-projeto)
- [Enunciado do projeto](#enunciado-do-projeto)
- [Técnicas e tecnologias utilizadas](#️-técnicas-e-tecnologias-utilizadas)
- [Autores](#autores)



## :hammer: Funcionalidades implantadas no projeto

- `Funcionalidade 1`: Criação do método transferir() na classe Banco; ele vai ser utilizado em todas as funcionalidades que envolva o fluxo de saldo entre as contas.
- `Observação 1`: Dentro do método transferir() tem as funções debitar(), que retira saldo da conta, e creditar(), que adiciona saldo na conta, desenvolvidas na classe Conta.
- `Funcionalidade 2`: Classe Cliente é uma thread no qual realiza o fluxo do saldo da conta do cliente para conta da loja (ATO DO CLIENTE REALIZAR UMA COMPRA NA LOJA), com a lógica dentro do método run() .
- `Funcionalidade 3a`: Classe Funcionário é uma thread no qual realiza o fluxo do saldo da conta da loja para conta de salário do funcionário. (ATO DO FUNCIONÁRIO RECEBER O PAGAMENTO FEITO PELA LOJA), com a lógica dentro do método run().
- `Observação 2`: As threads do Funcionário só vão ser startadas quando todas as threads dos clientes terminarem sua execução. 
- `Funcionalidade 3b`: Ainda na classe Funcionário, ele tbm vai realizar o fluxo do valor recebido pela loja entre as suas duas contas: conta salário e conta investimento, sendo a conta investimento = 20% do salario recebido; com a lógica dentro do método run().
- `Observação 3`: O saldo final das contas só vai ser impresso no terminal quando todas as threads terminarem suas execuções ( - join() ).

## Enunciado do projeto

![Enunciado do Projeto](enunciado.jpg)

  
## ✔️ Técnicas e tecnologias utilizadas

<img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="c" width="40" height="40"/>

## Autores

| [<img src="https://avatars.githubusercontent.com/u/128331199?v=4" width=115><br><sub>Kennedy Torres</sub>](https://github.com/Kennedy-Torres) | 
| :---: |
