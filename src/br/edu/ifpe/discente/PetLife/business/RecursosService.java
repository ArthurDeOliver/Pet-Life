package br.edu.ifpe.discente.PetLife.business;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;

import br.edu.ifpe.discente.PetLife.data.RecursosRepository;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import br.edu.ifpe.discente.PetLife.ui.entities.Medicamentos;
import br.edu.ifpe.discente.PetLife.ui.entities.Racoes;
import br.edu.ifpe.discente.PetLife.ui.entities.Vacinas;
import br.edu.ifpe.discente.PetLife.ui.exception.BusinessException;

public class RecursosService {

	private RecursosRepository repositoryR;

	public RecursosService() {
		this.repositoryR = new RecursosRepository();
	}

	public void criarVacina(Vacinas vacina) throws SQLException, BusinessException {
		if(vacina.getNomeVacina().trim().isEmpty()) {
			throw new BusinessException("O nome da Vacina não pode ser vazio!!");
		}
		if(vacina.getQuantidadeVacina() == 0) {
			throw new BusinessException("A quantidade de Vacinas precisa ser um numero maior que 0!");
		}
		if(vacina.getValorVacina() == 0) {
			throw new BusinessException("O valor da Vacina precisa ser um valor maior que 0!");
		}
		this.repositoryR.criarVacina(vacina);
	}

	public void criarMedicamento(Medicamentos medicamento) throws SQLException, BusinessException {
		if(medicamento.getNomeMedicamento().trim().isEmpty()) {
			throw new BusinessException("O nome do Medicamento não pode ser vazio!!");
		}
		if(medicamento.getQuantidadeMedicamento() == 0) {
			throw new BusinessException("A quantidade de Medicamentos precisa ser um numero maior que 0!");
		}
		if(medicamento.getValorMedicamento() == 0) {
			throw new BusinessException("O valor do Medicamento precisa ser um valor maior que 0!");
		}
		this.repositoryR.criarMedicamento(medicamento);
	}

	public void criarRacao(Racoes racao) throws SQLException, BusinessException {
		if(racao.getMarcaRacao().trim().isEmpty()) {
			throw new BusinessException("O nome da Ração não pode ser vazio!!");
		}
		if(racao.getQuantidadeRacao() == 0) {
			throw new BusinessException("A quantidade de Rações precisa ser um numero maior que 0!");
		}
		if(racao.getValorRacao() == 0) {
			throw new BusinessException("O valor da Ração precisa ser um valor maior que 0!");
		}
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
	public void atualizarMedicamento(String novoNome, int novaQuantidade, double novoValor, int id) throws SQLException, BusinessException {
		if(novoNome.trim().isEmpty()) {
			throw new BusinessException("O nome do Medicamento não pode ser vazio!!");
		}
		if(novaQuantidade == 0) {
			throw new BusinessException("A quantidade de Medicamentos precisa ser um numero maior que 0!");
		}
		if(novoValor == 0) {
			throw new BusinessException("O valor do Medicamento precisa ser um valor maior que 0!");
		}
		this.repositoryR.atualizarMedicamento(novoNome, novaQuantidade, novoValor, id);
	}
	public void atualizarRacao(String novoNome, double novaQuantidade, double novoValor, int id) throws SQLException, BusinessException {
		if(novoNome.trim().isEmpty()) {
			throw new BusinessException("O nome da Ração não pode ser vazio!!");
		}
		if(novaQuantidade == 0) {
			throw new BusinessException("A quantidade de Rações precisa ser um numero maior que 0!");
		}
		if(novoValor == 0) {
			throw new BusinessException("O valor da Ração precisa ser um valor maior que 0!");
		}
		this.repositoryR.atualizarRacao(novoNome, novaQuantidade, novoValor, id);
	}
	public void atualizarVacina(String novoNome, int novaQuantidade, double novoValor, int id) throws SQLException, BusinessException {
		if(novoNome.trim().isEmpty()) {
			throw new BusinessException("O nome da Vacina não pode ser vazio!!");
		}
		if(novaQuantidade == 0) {
			throw new BusinessException("A quantidade de Vacinas precisa ser um numero maior que 0!");
		}
		if(novoValor == 0) {
			throw new BusinessException("O valor da Vacina precisa ser um valor maior que 0!");
		}
		this.repositoryR.atualizarVacina(novoNome, novaQuantidade, novoValor, id);
	}
	public void inserirMedicamentoAnimal(Animais animal, Medicamentos medicamento) throws SQLException {
		this.repositoryR.inserirMedicamentoAnimal(animal, medicamento);
	}
	public void inserirVacinaAnimal(Animais animal, Vacinas vacina) throws SQLException {
		this.repositoryR.inserirVacinaAnimal(animal, vacina);
	}
	
}