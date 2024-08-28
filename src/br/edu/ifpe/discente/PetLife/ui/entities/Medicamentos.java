package br.edu.ifpe.discente.PetLife.ui.entities;

public class Medicamentos {

	private String nomeMedicamento;
	private int quantidadeMedicamento;
	private double valorMedicamento;
    private int id;
    
	public Medicamentos(String nomeMedicamento, int quantidadeMedicamento, double valorMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
		this.quantidadeMedicamento = quantidadeMedicamento;
		this.valorMedicamento = valorMedicamento;
	}    
	public Medicamentos(int id, String nomeMedicamento, int quantidadeMedicamento, double valorMedicamento) {
		this.id = id;
		this.nomeMedicamento = nomeMedicamento;
		this.quantidadeMedicamento = quantidadeMedicamento;
		this.valorMedicamento = valorMedicamento;	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	      return this.id + " - " + this.nomeMedicamento;
	}
	}