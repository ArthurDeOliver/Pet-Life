package br.edu.ifpe.discente.PetLife.ui.entities;

public class Adocoes {
	
	private int idPet;
	private String nomePet;
	private String tipoPet;
	private String nomeTutor;
	private String cpf;
	private String endereco;
	private String telefone;
	
	
	public Adocoes (int idPet, String nomePet, String tipoPet, String nomeTutor, String cpf, String endereco, String telefone) {
		this.idPet= idPet;
		this.nomePet= nomePet;
		this.tipoPet= tipoPet;
		this.nomeTutor= nomeTutor;
		this.cpf= cpf;
		this.endereco= endereco;
		this.telefone= telefone;
	}
	
	public int getIdPet() {
		return idPet;
	}
	public void setIdPet(int idPet) {
		this.idPet=idPet;
	}
	public String getNomePet() {
		return nomePet;
	}
	public void setNomePet (String nomePet) {
		this.nomePet= nomePet;
	}
	public String getTipoPet() {
		return tipoPet;
	}
	public void setTipoPet (String tipoPet) {
		this.tipoPet= tipoPet;
	}
	public String getNomeTutor() {
		return nomeTutor;
	}
	public void setNomeTutor (String nomeTutor) {
		this.nomeTutor= nomeTutor;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf=cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco=endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone=telefone;
	}
	
}
