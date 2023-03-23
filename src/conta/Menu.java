package conta;

import java.util.Scanner;

import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		int op;
		
		Scanner read = new Scanner (System.in);
	
		
		
		while (true) {
			
		
			System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + Cores.ANSI_WHITE_BACKGROUND+"\n|--------------------------------------------------------|");
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
			op = read.nextInt();
			
			if (op == 9) {
				System.out.println("\n\tObrigada por escolher o banco JMR, volte sempre!");
				read.close();
				System.exit(0);
			}
			
			
			switch (op) {
			
			case 1:
				System.out.println("----------------------------------------------------------");
				System.out.println("                    1 - CRIAR CONTA                       ");
				break;
				
			case 2: 
				System.out.println("----------------------------------------------------------");
				System.out.println("                 2 - LISTAR TODAS AS CONTAS               ");
				break; 
				
			case 3: 
				System.out.println("----------------------------------------------------------");
				System.out.println("                 3 - BUSCAR CONTA POR NÚMERO              ");
				break;
				
			case 4: 
				System.out.println("----------------------------------------------------------");
				System.out.println("                 4 - LISTAR TODAS AS CONTAS               ");
				break;
				
			case 5: 
				System.out.println("----------------------------------------------------------");
				System.out.println("                    5 - DELETAR CONTA                     ");
				break;
				
			case 6: 
				System.out.println("----------------------------------------------------------");
				System.out.println("                    6 - REALIZAR SAQUE                    ");
				break;
				
			case 7: 
				System.out.println("----------------------------------------------------------");
				System.out.println("                      7 - DEPOSITAR                       ");
				break;
				
			case 8: 
				System.out.println("----------------------------------------------------------");
				System.out.println("               8 - TRANFERENCIA ENTRE CONTAS              ");
				break;
				
			default: 
				System.out.println("----------------------------------------------------------");
				System.out.println("                     OPÇÃO INVÁLIDA!                      ");
				break;
			}
			
			
		}
	
		
	}

}