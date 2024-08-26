package br.edu.ifpe.discente.PetLife.business;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;

import br.edu.ifpe.discente.PetLife.data.RecursosRepository;
import br.edu.ifpe.discente.PetLife.ui.entities.Medicamentos;
import br.edu.ifpe.discente.PetLife.ui.entities.Racoes;
import br.edu.ifpe.discente.PetLife.ui.entities.Vacinas;

public class RecursosService {

	private RecursosRepository repositoryR;

	public RecursosService() {
		this.repositoryR = new RecursosRepository();
	}

	public void criarVacina(Vacinas vacina) throws SQLException {

		this.repositoryR.criarVacina(vacina);
	}

	public void criarMedicamento(Medicamentos medicamento) throws SQLException {
		this.repositoryR.criarMedicamento(medicamento);
	}

	public void criarRacao(Racoes racao) throws SQLException {
		this.repositoryR.criarRacao(racao);
	}

	public List<Racoes> retornarTodasRacoes() throws SQLException {
		return this.repositoryR.listarTodasRacoes();
	}

	public List<Medicamentos> retornarTodosMedicamentos() throws SQLException {
		return this.repositoryR.listarTodosMedicamentos();
	}

	public List<Vacinas> retornarTodasVacinas() throws SQLException {
		return this.repositoryR.listarTodasVacinas();
	}
	public void atualizarMedicamento(String novoNome, int novaQuantidade, double novoValor, int id) {
		this.repositoryR.atualizarMedicamento(novoNome, novaQuantidade, novoValor, id);
	}
	public void atualizarRacao(String novoNome, double novaQuantidade, double novoValor, int id) {
		this.repositoryR.atualizarRacao(novoNome, novaQuantidade, novoValor, id);
	}
	public void atualizarVacina(String novoNome, int novaQuantidade, double novoValor, int id) {
		this.repositoryR.atualizarVacina(novoNome, novaQuantidade, novoValor, id);
	}
	
}