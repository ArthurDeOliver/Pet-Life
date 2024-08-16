package br.edu.ifpe.discente.PetLife.ui.entities;

public class Medicamentos{
	
	private String Nome_Medicamento;
	private int Quantidade_Medicamento;
	private double Valor_Medicamento;
	
	public Medicamentos(String nome, int quantidade, double valor){
		this.Nome_Medicamento = nome;
		this.Quantidade_Medicamento = quantidade;
		this.Valor_Medicamento = valor;
	}

	public String getNome_Medicamento() {
		return this.Nome_Medicamento;
	}

	public void setNome_Medicamento(String nome) {
		this.Nome_Medicamento = nome;
	}

	public int getQuantidade_Medicamento() {
		return this.Quantidade_Medicamento;
	}

	public void setQuantidade_Medicamento(int quantidade) {
		this.Quantidade_Medicamento = quantidade;
	}

	public double getValor_Medicamento() {
		return this.Valor_Medicamento;
	}

	public void setValor_Medicamento(double valor) {
		this.Valor_Medicamento = valor;
	}
	
	
	
}