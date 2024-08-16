package br.edu.ifpe.discente.PetLife.ui.entities;

public class Racoes{
	
	private String Marca_Racao;
	private int Quantidade_Racao;
	private double Valor_Racao;
	
	public Racoes(String nome, int quantidade, double valor) {
		this.Marca_Racao = nome;
		this.Valor_Racao = quantidade;
		this.Valor_Racao = valor;	
	}

	public String getMarca_Racao() {
		return Marca_Racao;
	}

	public void setMarca_Racao(String marca) {
		Marca_Racao = marca;
	}

	public int getQuantidade_Racao() {
		return Quantidade_Racao;
	}

	public void setQuantidade_Racao(int quantidade) {
		Quantidade_Racao = quantidade;
	}

	public double getValor_Racao() {
		return Valor_Racao;
	}

	public void setValor_Racao(double valor) {
		Valor_Racao = valor;
	}
	
}