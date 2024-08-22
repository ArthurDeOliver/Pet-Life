package br.edu.ifpe.discente.PetLife.business;

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

	public void criarAnimal(Animais animal) throws BusinessException {
		try {
			repositoryA.criarAnimal(animal);
		} catch (DataAccessException e) {
			//TODO
		}
	}

	public List<Animais> retornarAnimal() throws BusinessException {
<<<<<<< HEAD
	    try {
	        return repositoryA.listarTodosAnimais();
	    } catch (DataAccessException e) {
	    	
	        throw new BusinessException("Não foi possível recuperar os animais.", e);
	    }
=======
		try {
			return repositoryA.listarTodosAnimais();
		} catch (DataAccessException e) {
			throw new BusinessException("Erro ao recuperar a lista de animais ", e);
		}
>>>>>>> 4212c4455d6db2499729fe9f571360d0d2be3583
	}

	public List<Animais> retornarAnimaisAptos() throws BusinessException {
		try {
			return repositoryA.listarAnimaisAptos();
		} catch (DataAccessException e) {
			
			throw new BusinessException("Erro ao recuperar a lista de animais aptos ", e);
		}
	}

	public void atualizarAnimal(String nome, int idade, String tipo, String raca, int racao, String status,
			String vacina, String foto, int id) throws BusinessException {
		try {
			repositoryA.atualizarAnimal(nome, idade, tipo, raca, racao, status, vacina, foto, id);
		} catch (DataAccessException e) {
			
			//TODO
		}
	}

	public void deletarAnimal(int id) throws BusinessException {
		try {
			repositoryA.deletarAnimal(id);
		} catch (DataAccessException e) {
			
			//TODO
		}
	}
}
