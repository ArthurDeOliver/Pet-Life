
package br.edu.ifpe.discente.PetLife.business;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpe.discente.PetLife.data.AnimaisRepository;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import br.edu.ifpe.discente.PetLife.ui.exception.BusinessException;
import br.edu.ifpe.discente.PetLife.ui.exception.DataAccessException;

public class AnimaisService {

	private AnimaisRepository repositoryA;

	public AnimaisService() {

		this.repositoryA = new AnimaisRepository();
	}

	public void criarAnimal(Animais animal) throws BusinessException { // aprimorar
		try {
			repositoryA.criarAnimal(animal);
		} catch (DataAccessException e) {
			// TODO
		}

	}

	public List<Animais> retornarAnimal() throws BusinessException { // aprimorar
		try {

			return repositoryA.listarTodosAnimais();

		} catch (DataAccessException e) {
			// TODO
		}
		return null;
	}

	public List<Animais> retornarAnimaisAptos() throws BusinessException { // aprimorar
		try {

			return repositoryA.listarAnimaisAptos();

		} catch (DataAccessException e) {
			// TODO
		}
		return null;
	}

	public void atualizarAnimal(String nome, int idade, String tipo, String raca, int racao, String status,
			String vacina, String foto, int id) throws BusinessException {
		try {
			repositoryA.atualizarAnimal(nome, idade, tipo, raca, racao, status, vacina, foto, id);
		} catch (DataAccessException e) {
			// TODO
		}
	}

	public void deletarAnimal(int id) throws BusinessException {
		try {
			repositoryA.deletarAnimal(id);
		} catch (DataAccessException e) {
			// TODO regras de negócio

		}

	}
}
