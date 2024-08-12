package br.edu.ifpe.discente.PetLife.ui.entities;

public class Tutor {
	
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	
	
	public Tutor (String nome, String cpf, String endereco, String telefone) {
		this.nome= nome;
		this.cpf= cpf;
		this.endereco= endereco;
		this.telefone= telefone;
	}
	
	public String get_nome() {
		return nome;
	}
	public void set_nome(String nome) {
		this.nome=nome;
	}
	public String get_cpf() {
		return cpf;
	}
	public void set_cpf(String cpf) {
		this.cpf=cpf;
	}
	public String get_endereco() {
		return endereco;
	}
	public void set_endereco(String endereco) {
		this.endereco=endereco;
	}
	public String get_telefone() {
		return telefone;
	}
	public void set_telefone(String telefone) {
		this.telefone=telefone;
	}
	
}
