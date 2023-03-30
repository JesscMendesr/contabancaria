package conta;



import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.util.Cores;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		
		
		int op, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;
	
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(),123,1,"João da Silva",1000f,100.0f);
		contas.cadastrar(cc1);

		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(),124,1,"Maria da Silva",2000f,100.0f);
		contas.cadastrar(cc2);

		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(),125,2,"Mariana Santos",4000f,12);
		contas.cadastrar(cp1);

		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(),126,2,"Juliana Ramos",8000f,15);
		contas.cadastrar(cp2);
		
		Scanner read = new Scanner (System.in);
		
		
		while (true) {
			
		
			System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_WHITE_BACKGROUND+
					"\n|--------------------------------------------------------|");
			System.out.println("|                     MENU - BANCO JMR                   |");
			System.out.println("|--------------------------------------------------------|");
			System.out.println("|          (1) Criar conta                               |");
			System.out.println("|          (2) Listar todas as contas                    |");
			System.out.println("|          (3) Buscar conta por número                   |");
			System.out.println("|          (4) Atualizar dados                           |");
			System.out.println("|          (5) Deletar conta                             |");
			System.out.println("|          (6) Sacar                                     |");
			System.out.println("|          (7) Depositar                                 |");
			System.out.println("|          (8) Fazer transferência entre as contas       |");
			System.out.println("|          (9) Sair                                      |");
			System.out.println("|--------------------------------------------------------|");
			System.out.println("|          Digite a opção da operação que deseja:        |");
			System.out.println("|--------------------------------------------------------|\n");
			try {
				op = read.nextInt();
				
			}catch(InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				read.nextLine();
				op = 0;
			}
			
			
			if (op == 9) {
				System.out.println("\n\tObrigada por escolher o banco JMR, volte sempre!");
				read.close();
				System.exit(0);
			}
			
			
			switch (op) {
			
			case 1:
				System.out.println("----------------------------------------------------------");
				System.out.println("                    1 - CRIAR CONTA                       ");
				
				System.out.println("Digite o Número da Agência: ");
				agencia = read.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				read.skip("\\R?");
				titular = read.nextLine();
				
				do {
					System.out.println("Digite o tipo de conta (1-CC ou 2-CP): ");
					tipo = read.nextInt();
				}while (tipo < 1 && tipo > 2);
				
				
				System.out.println("Digite o saldo da conta (R$): ");
				saldo = read.nextFloat();
				
				
				switch(tipo) {
					case 1 -> {
						System.out.println("Digite o limite de Crédito (R$): ");
						limite = read.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversário da conta: ");
						aniversario = read.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}
				keyPress();
				break;
				
			case 2: 
				System.out.println("----------------------------------------------------------");
				System.out.println("                 2 - LISTAR TODAS AS CONTAS               ");
				contas.listarTodas();
				keyPress();
				break; 
				
			case 3: 
				System.out.println("----------------------------------------------------------");
				System.out.println("                 3 - BUSCAR CONTA POR NÚMERO              ");
				System.out.println("Digite o Número da Conta: ");
				numero = read.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
				
			case 4: 
				System.out.println("----------------------------------------------------------");
				System.out.println("                4 - ATUALZIAR DADOS DA CONTA              ");
				
				System.out.println("Digite o Número da Conta: ");
				numero = read.nextInt();
				
				if (contas.buscarNaCollection(numero) != null) {
					System.out.println("Digite o Número da Agência: ");
					agencia = read.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					read.skip("\\R?");
					titular = read.nextLine();
					
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = read.nextFloat();
					
					tipo = contas.retornaTipo(numero);
					
					
					switch(tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = read.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversário da Conta: ");
						aniversario = read.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de Conta Inválido!");
					}
					}
					
				}else {
					System.out.println("\nConta Não Encontrada!");
				}
				
				keyPress();
				break;
				
			case 5: 
				System.out.println("----------------------------------------------------------");
				System.out.println("                    5 - DELETAR CONTA                     ");
				
				System.out.println("Digite o número da conta: ");
				numero = read.nextInt();
				
				contas.deletar(numero);
				
				keyPress();
				break;
				
			case 6: 
				System.out.println("----------------------------------------------------------");
				System.out.println("                    6 - REALIZAR SAQUE                    ");
				
				System.out.println("Digite o número da conta: ");
				numero = read.nextInt();
				
				
				do {
					System.out.println("Digite o Valor do Saque (R$): ");
					valor = read.nextFloat();
				}while (valor <= 0);
				
				
				contas.sacar(numero, valor);
				
				keyPress();
				break;
				
			case 7: 
				System.out.println("----------------------------------------------------------");
				System.out.println("                      7 - DEPOSITAR                       ");
				
				System.out.println("Digite o número da conta: ");
				numero = read.nextInt();
				
				do {
					System.out.println("Digite o Valor do Depósito (R$): ");
					valor = read.nextFloat();
				}while(valor <= 0);
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;
				
			case 8: 
				System.out.println("----------------------------------------------------------");
				System.out.println("               8 - TRANFERENCIA ENTRE CONTAS              ");
				
				System.out.println("Digite o Número da Conta de Origem: ");
				numero = read.nextInt();
				System.out.println("Digite o Número da Conta de Destino: ");
				numeroDestino = read.nextInt();
				
				do {
					System.out.println("Digite o Valor da Transferência (R$): ");
					valor = read.nextFloat();
				}while (valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);
				
				
				keyPress();
				break;
				
			default: 
				System.out.println("\nOpção Inválida!");
				keyPress();
				break;
			}
			
			
		}
	
		
	}
	
	
	public static void keyPress() {
		try {
			System.out.println("\n\nPressione Enter para Continuar...");
			System.in.read();
		}catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

}