package br.edu.ifpe.discente.PetLife.business;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;

import br.edu.ifpe.discente.PetLife.data.RecursosRepository;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import br.edu.ifpe.discente.PetLife.ui.entities.GraficoBarra;
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
		if (vacina.getNomeVacina().trim().isEmpty()) {
			throw new BusinessException("O nome da Vacina não pode ser vazio!!");
		}
		if (vacina.getQuantidadeVacina() == 0) {
			throw new BusinessException("A quantidade de Vacinas não pode ser 0 ou nula!");
		}
		if (vacina.getValorVacina() == 0) {
			throw new BusinessException("O valor da Vacina não pode ser 0 ou nulo!");
		}
		this.repositoryR.criarVacina(vacina);
	}

	public void criarMedicamento(Medicamentos medicamento) throws SQLException, BusinessException {
		if (medicamento.getNomeMedicamento().trim().isEmpty()) {
			throw new BusinessException("O nome do Medicamento não pode ser vazio!!");
		}
		if (medicamento.getQuantidadeMedicamento() == 0) {
			throw new BusinessException("A quantidade de Medicamentos não pode ser 0 ou nula!");
		}
		if (medicamento.getValorMedicamento() == 0) {
			throw new BusinessException("O valor do Medicamento não pode ser 0 ou nulo!");
		}
		this.repositoryR.criarMedicamento(medicamento);
	}

	public void criarRacao(Racoes racao) throws SQLException, BusinessException {
		if (racao.getMarcaRacao().trim().isEmpty()) {
			throw new BusinessException("O nome da Ração não pode ser vazio!!");
		}
		if (racao.getQuantidadeRacao() == 0) {
			throw new BusinessException("A quantidade de Rações não pode ser 0 ou nula!");
		}
		if (racao.getValorRacao() == 0) {
			throw new BusinessException("O valor da Ração não pode ser 0 ou nulo!");
		}
		this.repositoryR.criarRacao(racao);
	}

	public List<Racoes> retornarTodasRacoes() throws BusinessException, SQLException {
		return this.repositoryR.listarTodasRacoes();
	}

	public List<Medicamentos> retornarTodosMedicamentos() throws BusinessException, SQLException {
		return this.repositoryR.listarTodosMedicamentos();
	}

	public List<Vacinas> retornarTodasVacinas() throws BusinessException, SQLException {
		return this.repositoryR.listarTodasVacinas();
	}

	public void atualizarMedicamento(String novoNome, int novaQuantidade, double novoValor, int id)
			throws SQLException, BusinessException {
		if (novoNome.trim().isEmpty()) {
			throw new BusinessException("O novo nome do Medicamento não pode ser vazio!!");
		}
		if (novaQuantidade == 0) {
			throw new BusinessException("A nova quantidade de Medicamentos não pode ser 0 ou nula!");
		}
		if (novoValor == 0) {
			throw new BusinessException("O novo valor do Medicamento não pode ser 0 ou nulo!");
		}
		this.repositoryR.atualizarMedicamento(novoNome, novaQuantidade, novoValor, id);
	}

	public void atualizarRacao(String novoNome, double novaQuantidade, double novoValor, int id)
			throws SQLException, BusinessException {
		if (novoNome.trim().isEmpty()) {
			throw new BusinessException("O novo nome da Ração não pode ser vazio!!");
		}
		if (novaQuantidade == 0) {
			throw new BusinessException("A nova quantidade de Rações não pode ser 0 ou nula!");
		}
		if (novoValor == 0) {
			throw new BusinessException("O novo valor da Ração não pode ser 0 ou nulo!");
		}
		this.repositoryR.atualizarRacao(novoNome, novaQuantidade, novoValor, id);
	}

	public void atualizarVacina(String novoNome, int novaQuantidade, double novoValor, int id)
			throws SQLException, BusinessException {
		if (novoNome.trim().isEmpty()) {
			throw new BusinessException("O novo nome da Vacina não pode ser vazio!!");
		}
		if (novaQuantidade == 0) {
			throw new BusinessException("A nova quantidade de Vacinas não pode ser 0 ou nula!");
		}
		if (novoValor == 0) {
			throw new BusinessException("O novo valor da Vacina não pode ser 0 ou nulo!");
		}
		this.repositoryR.atualizarVacina(novoNome, novaQuantidade, novoValor, id);
	}

	public void inserirMedicamentoAnimal(Animais animal, Medicamentos medicamento)
			throws SQLException, BusinessException {
		if (this.repositoryR.animalJaMedicado(animal, medicamento)) {
			throw new BusinessException("O animal já possui esse Medicamento!!");
		}
		;
		this.repositoryR.inserirMedicamentoAnimal(animal, medicamento);
	}

	public void inserirVacinaAnimal(Animais animal, Vacinas vacina) throws SQLException, BusinessException {
		if (this.repositoryR.animalJaVacinado(animal, vacina)) {
			throw new BusinessException("O animal já possui essa Vacina!!");
		}
		;
		this.repositoryR.inserirVacinaAnimal(animal, vacina);
	}

	public boolean animalJaVacinado(Animais animal, Vacinas vacina) throws SQLException, BusinessException {
		return this.repositoryR.animalJaVacinado(animal, vacina);
	}

	public void diminuirQuantidadeMedicamento(int id_Medicamento, int quantidadeNova)
			throws SQLException, BusinessException {
		this.repositoryR.diminuirQuantidadeMedicamento(id_Medicamento, quantidadeNova);
	}

	public void diminuirQuantidadeVacina(int id_Vacina, int quantidadeNova) throws SQLException, BusinessException {
		this.repositoryR.diminuirQuantidadeVacina(id_Vacina, quantidadeNova);
	}

	public double retornarTotalRacoes() throws SQLException {
		return this.repositoryR.totalValorRacoes();
	}

	public double retornarTotalMedicamentos() throws BusinessException, SQLException {
		return this.repositoryR.totalValorMedicamentos();
	}

	public double retornarTotalVacinas() throws BusinessException, SQLException {
		return this.repositoryR.totalValorVacinas();
	}

	public GraficoBarra criarGrafico() throws BusinessException, SQLException {

		double totalRacoes = this.repositoryR.totalValorRacoes();
		double totalMedicamentos = this.repositoryR.totalValorMedicamentos();
		double totalVacinas = this.repositoryR.totalValorVacinas();
		double totalRecursos = totalRacoes + totalMedicamentos + totalVacinas;
		GraficoBarra grafico = new GraficoBarra(totalRacoes, totalMedicamentos, totalVacinas, totalRecursos);
		grafico.setBounds(391, 95, 503, 307);
		return grafico;
	}

	public double totalGastosAnimal(Animais animal) throws SQLException {
		return this.repositoryR.totalGastosAnimal(animal);
	}
}