package com.ti2cc;

public class Time {
	private int id;
	private String nome;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int pontuacao;
	
	public Time() {
		this.id = -1;
		this.nome = "";
		this.vitorias = -1;
		this.empates = -1;
		this.derrotas = -1;
		this.pontuacao = -1;
	}
	
	public Time(int id, String nome, int vitorias, int empates, int derrotas) {
		this.id = id;
		this.nome = nome;
		this.vitorias = vitorias;
		this.empates = empates;
		this.derrotas = derrotas;
		this.pontuacao = vitorias * 3 + empates;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}
	
	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	
	/*public void setPontuacao(int empates, int vitorias) {
		this.pontuacao = vitorias * 3 + empates;
	}*/

	@Override
	public String toString() {
		return "Time: [id = " + id + ", nome = " + nome + ", vitorias = " + vitorias + ", empates = " + empates  + ", derrotas = " + derrotas + ", pontuacao = " + pontuacao + "]";
	}	
}
