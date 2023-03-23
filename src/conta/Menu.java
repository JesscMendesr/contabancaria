package conta;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		int op;
		
		Scanner read = new Scanner (System.in);
		
		
		while (true) {
			
			System.out.println("\n-----------------------------------------------------------");
			System.out.println("\n\t\t\tMENU - BANCO JMR");
			System.out.println("\n-----------------------------------------------------------");
			System.out.println("\n\t(1)\tCriar conta");
			System.out.println("\n\t(2)\tListar todas as contas");
			System.out.println("\n\t(3)\tBuscar conta por número");
			System.out.println("\n\t(4)\tAtualizar dados");
			System.out.println("\n\t(5)\tDeletar conta");
			System.out.println("\n\t(6)\tSacar");
			System.out.println("\n\t(7)\tDepositar");
			System.out.println("\n\t(8)\tFazer transferência entre as contas");
			System.out.println("\n\t(9)\tSair");
			System.out.println("\n-----------------------------------------------------------");
			System.out.println("\n\tDigite a opção da operação que deseja: ");
			op = read.nextInt();
			
			
			if (op == 9) {
				System.out.println("\n\tObrigada por escolher o banco JMR, volte sempre!");
				read.close();
				System.exit(0);
			}
			
			
			switch (op) {
			
			case 1:
				System.out.println("-----------------------------------------------------------");
				System.out.println("\n\t\t\tCriar conta");
				break;
				
			case 2: 
				System.out.println("-----------------------------------------------------------");
				System.out.println("\n\t\t\tListar todas as contas");
				break;
				
			case 3: 
				System.out.println("-----------------------------------------------------------");
				System.out.println("\n\t\t\tCriar conta");
				break;
				
			case 4: 
				System.out.println("-----------------------------------------------------------");
				System.out.println("\n\t\t\tListar todas as contas");
				break;
				
			case 5: 
				System.out.println("-----------------------------------------------------------");
				System.out.println("\n\t\t\tBuscar conta por número");
				break;
				
			case 6: 
				System.out.println("-----------------------------------------------------------");
				System.out.println("\n\t\t\tAtualizar dados");
				break;
				
			case 7: 
				System.out.println("-----------------------------------------------------------");
				System.out.println("\n\t\t\tDepositar");
				break;
				
			case 8: 
				System.out.println("-----------------------------------------------------------");
				System.out.println("\n\t\t\tFazer transferência entre as contas");
				break;
				
			default: 
					System.out.println("\nOpção inválida!");
					break;
			}
			
			
		}
	
		
	}

}