package br.edu.ifpe.discente.PetLife.business;

import java.util.List;

import br.edu.ifpe.discente.PetLife.data.AdocaoRepository;
import br.edu.ifpe.discente.PetLife.ui.entities.Adocoes;
import br.edu.ifpe.discente.PetLife.ui.exception.BusinessException;
import br.edu.ifpe.discente.PetLife.ui.exception.DataAccessException;

public class AdocaoService {

	private AdocaoRepository adocaoRepositoryA;

	public AdocaoService() {
		this.adocaoRepositoryA = new AdocaoRepository();
	}

	public void adotar(Adocoes adocao) throws BusinessException {
		try {
			adocaoRepositoryA.adotar(adocao);
		} catch (DataAccessException e) {
			//TODO
		}
	}

	public List<Adocoes> listarAdocoes() throws BusinessException {
		try {
			return adocaoRepositoryA.listarAdocoes();
		} catch (DataAccessException e) {
			throw new BusinessException("Erro ao listar adoções ", e);
		}
	}
}
