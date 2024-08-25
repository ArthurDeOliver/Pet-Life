package br.edu.ifpe.discente.PetLife.ui.entities;

public class Medicamentos {

	private String nomeMedicamento;
	private int quantidadeMedicamento;
	private double valorMedicamento;

	public Medicamentos(String nomeMedicamento, int quantidadeMedicamento, double valorMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
		this.quantidadeMedicamento = quantidadeMedicamento;
		this.valorMedicamento = valorMedicamento;
	}

	public String getNomeMedicamento() {
		return nomeMedicamento;
	}

	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}

	public int getQuantidadeMedicamento() {
		return quantidadeMedicamento;
	}

	public void setQuantidadeMedicamento(int quantidadeMedicamento) {
		this.quantidadeMedicamento = quantidadeMedicamento;
	}

	public double getValorMedicamento() {
		return valorMedicamento;
	}

	public void setValorMedicamento(double valorMedicamento) {
		this.valorMedicamento = valorMedicamento;
	}
	@Override
	public String toString() {	
	      return this.getNomeMedicamento();
	}
	}