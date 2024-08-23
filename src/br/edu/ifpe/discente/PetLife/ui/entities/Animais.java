package br.edu.ifpe.discente.PetLife.ui.entities;

public class Animais {

	private int id;
	private String nome;
	private int idade;
	private String tipo;
	private String raca;
	private int racao;
	private String status;
	private String vacina;
	private String foto;

	public Animais(String nome, int idade, String tipo, String raca, int racao, String status, String vacina,
			String foto) {
		this.nome = nome;
		this.idade = idade;
		this.tipo = tipo;
		this.raca = raca;
		this.status = status;
		this.vacina = vacina;
		this.racao = racao;
	}

	public Animais(int id, String nome, int idade, String tipo, String raca, int racao, String status, String vacina,
			String foto) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.tipo = tipo;
		this.raca = raca;
		this.status = status;
		this.vacina = vacina;
		this.racao = racao;
	}

	public Animais(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public int getID() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVacina() {
		return vacina;
	}

	public void setVacina(String vacina) {
		this.vacina = vacina;
	}

	public int getRacao() {
		return racao;
	}

	public void setRacao(int racao) {
		this.racao = racao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
