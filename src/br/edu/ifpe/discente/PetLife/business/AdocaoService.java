package br.edu.ifpe.discente.PetLife.business;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpe.discente.PetLife.data.AdocaoRepository;
import br.edu.ifpe.discente.PetLife.ui.entities.Adocoes;
import br.edu.ifpe.discente.PetLife.ui.exception.BusinessException;

public class AdocaoService {

	private AdocaoRepository adocaoRepositoryA;

	public AdocaoService() {
		this.adocaoRepositoryA = new AdocaoRepository();
	}

	public void adotar(Adocoes adocao) throws BusinessException, SQLException {

		adocaoRepositoryA.adotar(adocao);

	}

	public List<Adocoes> listarAdocoes() throws BusinessException, SQLException { // aprimorar
		return adocaoRepositoryA.listarAdocoes();
	}

}
