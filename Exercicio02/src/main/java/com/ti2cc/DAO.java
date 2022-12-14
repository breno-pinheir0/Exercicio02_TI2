package com.ti2cc;

import java.sql.*;

public class DAO {
	private Connection conexao;
	
	public DAO() {
		conexao = null;
	}
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "teste";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "ti2cc";
		String password = "ti@cc";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexao efetuada com o postgres!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexao NAO efetuada com o postgres -- Driver nao encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexao NAO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public boolean inserirTime(Time time) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("INSERT INTO time (id, nome, vitorias, empates, derrotas) "
					       + "VALUES ("+time.getID()+ ", '" + time.getNome() + "', '"  
					       + time.getVitorias() + "', '" + time.getEmpates() + "', '" + time.getDerrotas() + "');");
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean atualizarTime(Time time) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE time SET nome = '" + time.getNome() + "', vitorias = '"  
				       + time.getVitorias() + "', empates = '" + time.getEmpates() + "', derrotas = '" + time.getDerrotas() + "'"
					   + " WHERE id = " + time.getID();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean excluirTime(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM time WHERE id = " + id);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public Time[] getTimes() {
		Time[] time = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM time");		
	         if(rs.next()){
	             rs.last();
	             time = new Time[rs.getRow()];
	             rs.beforeFirst();

	             for(int i = 0; rs.next(); i++) {
	            	 time[i] = new Time(rs.getInt("id"), rs.getString("nome"), 
	                		                  rs.getInt("vitorias"), rs.getInt("empates"), rs.getInt("derrotas"));
	             }
	          }
	          st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return time;
	}

}