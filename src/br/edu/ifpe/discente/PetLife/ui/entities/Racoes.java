package br.edu.ifpe.discente.PetLife.ui.entities;

public class Racoes {

	private String marcaRacao;
	private int quantidadeRacao;
	private double valorRacao;

	public Racoes(String marcaRacao, int quantidadeRacao, double valorRacao) {
		this.marcaRacao = marcaRacao;
		this.quantidadeRacao = quantidadeRacao;
		this.valorRacao = valorRacao;
	}

	public String getMarcaRacao() {
		return marcaRacao;
	}

	public void setMarcaRacao(String marcaRacao) {
		this.marcaRacao = marcaRacao;
	}

	public int getQuantidadeRacao() {
		return quantidadeRacao;
	}

	public void setQuantidadeRacao(int quantidadeRacao) {
		this.quantidadeRacao = quantidadeRacao;
	}

	public double getValorRacao() {
		return valorRacao;
	}

	public void setValorRacao(double valorRacao) {
		this.valorRacao = valorRacao;
	}

}