package com.ti2cc;

public class Aplicativo {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();

		
		//Inserir um elemento na tabela
		Time time = new Time(01, "Cruzeiro", 25, 4, 8);
		if(dao.inserirTime(time) == true) {
			System.out.println("Inserção com sucesso -> " + time.toString());
		}
		

		//Atualizar usuário
		time.setVitorias(29);
		dao.atualizarTime(time);

		
		System.out.println("==== Mostrar usuários === ");
		Time [] times = dao.getTimes();
		for(int i = 0; i < times.length; i++) {
			System.out.println(times[i].toString());
		}
		
		//Excluir usuário
		dao.excluirTime(time.getID());

		dao.close();
	}
}