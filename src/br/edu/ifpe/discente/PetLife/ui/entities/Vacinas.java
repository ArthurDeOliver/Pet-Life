package br.edu.ifpe.discente.PetLife.ui.entities;

public class Vacinas {

	private String nomeVacina;
	private int quantidadeVacina;
	private double valorVacina;
	
	public Vacinas(String nomeVacina, int quantidadeVacina, double valorVacina) {
		this.nomeVacina = nomeVacina;
		this.quantidadeVacina = quantidadeVacina;
		this.valorVacina = valorVacina;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public int getQuantidadeVacina() {
		return quantidadeVacina;
	}

	public void setQuantidadeVacina(int quantidadeVacina) {
		this.quantidadeVacina = quantidadeVacina;
	}

	public double getValorVacina() {
		return valorVacina;
	}

	public void setValorVacina(double valorVacina) {
		this.valorVacina = valorVacina;
	}
	
	@Override	
    public String toString() {	
      return this.getNomeVacina();
}
}