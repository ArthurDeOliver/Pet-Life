package br.edu.ifpe.discente.PetLife.ui.entities;

public class Vacinas{
	
	private String Nome_Vacina;
	private int Quantidade_Vacina;
	private double Valor_Vacina;
	
	public Vacinas(String nome, int quantidade, double valor) {
		this.Nome_Vacina = nome;
		this.Quantidade_Vacina = quantidade;
		this.Valor_Vacina = valor;
	}

	public String getNome_Vacina() {
		return Nome_Vacina;
	}

	public void setNome_Vacina(String nome) {
		Nome_Vacina = nome;
	}

	public int getQuantidade_Vacina() {
		return Quantidade_Vacina;
	}

	public void setQuantidade_Vacina(int quantidade) {
		Quantidade_Vacina = quantidade;
	}

	public double getValor_Vacina() {
		return Valor_Vacina;
	}

	public void setValor_Vacina(double valor) {
		Valor_Vacina = valor;
	}
	
}