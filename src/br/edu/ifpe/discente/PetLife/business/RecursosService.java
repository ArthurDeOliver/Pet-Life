package br.edu.ifpe.discente.PetLife.business;

import java.sql.SQLException;

import br.edu.ifpe.discente.PetLife.data.RecursosRepository;
import br.edu.ifpe.discente.PetLife.ui.entities.Medicamentos;
import br.edu.ifpe.discente.PetLife.ui.entities.Vacinas;
import br.edu.ifpe.discente.PetLife.ui.exception.BusinessException;
import br.edu.ifpe.discente.PetLife.ui.exception.DataAccessException;

public class RecursosService {

	private RecursosRepository repositoryR;

	public RecursosService() {
		this.repositoryR = new RecursosRepository();
	}

	public void criarVacina(Vacinas vacina) throws BusinessException {
		try {

			this.repositoryR.criarVacina(vacina);
		} catch (DataAccessException e) {
			// TODO
		}
	}

	public void criarMedicamento(Medicamentos medicamento) throws BusinessException {
		try {
			this.repositoryR.criarMedicamento(medicamento);
		} catch (DataAccessException e) {
			// TODO
		}

	}
}