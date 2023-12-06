package br.org.sesisp.model;



public class Usuario {
	private int rm;
	private String nome;
	private int idade;
	private String data;
	private String reuniao;
	public int getRm() {
		return rm;
	}
	public void setRm(int rm) {
		this.rm = rm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getReuniao() {
		return reuniao;
	}
	public void setReuniao(String reuniao) {
		this.reuniao = reuniao;
	}
}
