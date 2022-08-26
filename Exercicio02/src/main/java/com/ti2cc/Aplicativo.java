package com.ti2cc;
import java.util.*;

public class Aplicativo {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		Scanner scanner = new Scanner(System.in);
		int opcao = 0;
		
		dao.conectar();
		
		do {
			
			
			
		//Imprimir o menu com as funções CRUD
		System.out.println(" Escolha a opcao que deseja:");
		System.out.println(" 1) Listar");
		System.out.println(" 2) Inserir");
		System.out.println(" 3) Excluir");
		System.out.println(" 4) Atualizar");
		System.out.println(" 5) Sair");
		
		 opcao = scanner.nextInt();

		//Imprimir os elementos na tela
		
		if (opcao == 1) {
			System.out.println("==== Mostrar Times ==== ");
			Time [] times = dao.getTimes();
			for(int i = 0; i < times.length; i++) {
				System.out.println(times[i].toString());
			}
		}
		
		//Inserir um elemento na tabela
		
		if (opcao == 2) {
			System.out.print("\n Digite o nome do time: ");
			String nome = scanner.next();
			System.out.println(" Digite a quantidade de vitorias: ");
			int vitoria = scanner.nextInt();
			System.out.println("\n Digite a quantidade de empates: ");
			int empate = scanner.nextInt();
			System.out.println(" Digite a quantidade de derrotas: ");
			int derrota = scanner.nextInt();
			Time time = new Time(5, nome, vitoria, empate, derrota);
			if(dao.inserirTime(time) == true) {
				System.out.println("Insercao com sucesso -> " + time.toString());
			}
		}
		
		//Excluir um time
		
		if (opcao == 3) {
			System.out.print("\n Digite ID do time que deseja excluir: ");
			int id = scanner.nextInt();
			dao.excluirTime(id);
			if (dao.excluirTime(id) == false) {
				System.out.println(" Nao foi possivel excluir o time desejado. Lembrando que os times disponiveis para exclusao sao os seguintes: " );
				Time [] times = dao.getTimes();
				for(int i = 0; i < times.length; i++) {
					System.out.println(times[i].toString());
				}
			} else {
					System.out.println("Excluido com sucesso!");
				}
			
		}
		

		//Atualizar time
		
		if (opcao == 4) {
			
			char escolha;
			int derrota = 0, vitoria = 0, empate = 0;
			String nome = "";
			
			System.out.print("\n Digite ID do time que deseja atualizar: ");
			int id = scanner.nextInt();
			
			/*System.out.print("\n Deseja alterar o nome? ");
			escolha = scanner.next().charAt(0);
			if (escolha == 's') {
				*/System.out.print("\n Digite o nome do time: ");
				nome = scanner.next();
			/*} else {
				
				if (escolha == 'S') {
					System.out.print("\n Digite o nome do time: ");
					nome = scanner.next();
				}
			}*/
			/*System.out.print("\n Deseja alterar a quantidade de vitorias? ");
			escolha = scanner.next().charAt(0);
			if (escolha == 's') {
				*/System.out.println(" Digite a quantidade de vitorias: ");
				vitoria = scanner.nextInt();
			/*} else {
				
				if (escolha == 'S') {
					System.out.println(" Digite a quantidade de vitorias: ");
					vitoria = scanner.nextInt();
				}
			}*/
			/*System.out.print("\n Deseja alterar a quantidade de empates? ");
			escolha = scanner.next().charAt(0);
			if (escolha == 's') {
				*/System.out.println("\n Digite a quantidade de empates: ");
				empate = scanner.nextInt();
			/*} else {
				
				if (escolha == 'S') {
					System.out.println("\n Digite a quantidade de empates: ");
					empate = scanner.nextInt();
				}
			}*/
			/*System.out.print("\n Deseja alterar a quantidade de derrotas? ");
			escolha = scanner.next().charAt(0);
			if (escolha == 's') {
				*/System.out.println(" Digite a quantidade de derrotas: ");
				derrota = scanner.nextInt();
			/*} else {
				
				if (escolha == 'S') {
					System.out.println(" Digite a quantidade de derrotas: ");
					derrota = scanner.nextInt();
				} else {} 
			}*/
			

			Time time = new Time(id, nome, vitoria, empate, derrota);
			dao.atualizarTime(time);
			if (dao.atualizarTime(time)) {
				System.out.println(" Nao foi possivel atualizar o time desejado. Lembrando que os times disponiveis para exclusao sao os seguintes: " );
				Time [] times = dao.getTimes();
				for(int i = 0; i < times.length; i++) {
					System.out.println(times[i].toString());
				}
			} else { System.out.println("Alterado com sucesso!");}
		}

		} while(opcao != 5);
		
		System.out.println("Fim do programa!!!");
		dao.close();
	}
}