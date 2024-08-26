package br.edu.ifpe.discente.PetLife.ui.entities;

public class Racoes {

	private String marcaRacao;
	private double quantidadeRacao;
	private double valorRacao;
    private int id;
    
	public Racoes(String marcaRacao, double quantidadeRacao, double valorRacao) {
		this.marcaRacao = marcaRacao;
		this.quantidadeRacao = quantidadeRacao;
		this.valorRacao = valorRacao;
	}
	
	public Racoes(int id, String marcaRacao, double quantidadeRacao, double valorRacao) {
		this.id = id;
		this.marcaRacao = marcaRacao;
		this.quantidadeRacao = quantidadeRacao;
		this.valorRacao = valorRacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarcaRacao() {
		return marcaRacao;
	}

	public void setMarcaRacao(String marcaRacao) {
		this.marcaRacao = marcaRacao;
	}

	public double getQuantidadeRacao() {
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

	@Override	
    public String toString() {	
		return this.id + "-" + this.marcaRacao;
}
}