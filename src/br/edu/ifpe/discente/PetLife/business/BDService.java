package br.edu.ifpe.discente.PetLife.business;

import br.edu.ifpe.discente.PetLife.data.AnimaisRepository;
import br.edu.ifpe.discente.PetLife.data.RecursosRepository;
import br.edu.ifpe.discente.PetLife.data.AdocaoRepository;
import br.edu.ifpe.discente.PetLife.ui.exception.BusinessException;
import br.edu.ifpe.discente.PetLife.ui.exception.DataAccessException;

public class BDService {

	private AnimaisRepository repositoryA;
	private RecursosRepository repositoryR;
	private AdocaoRepository adocaorepositoryA;

	public BDService() {
		this.repositoryA = new AnimaisRepository();
		this.repositoryR = new RecursosRepository();
		this.adocaorepositoryA = new AdocaoRepository();
	}

	public void iniciarBD() throws BusinessException {
		try {
			repositoryA.iniciarBd();
			repositoryR.iniciarBdRecursos();
			adocaorepositoryA.iniciarBdAdocoes();
		} catch (DataAccessException e) {
			
			//TODO
		}
	}
}
