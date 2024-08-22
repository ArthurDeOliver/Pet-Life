package br.edu.ifpe.discente.PetLife.business;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpe.discente.PetLife.data.AdocaoRepository;
import br.edu.ifpe.discente.PetLife.ui.entities.Adocoes;


public class AdocaoService {
	
	private AdocaoRepository adocaoRepositoryA;
	
public AdocaoService() {
		this.adocaoRepositoryA = new AdocaoRepository();
	}

public void adotar (Adocoes adocao) throws SQLException { //aprimorar
	adocaoRepositoryA.adotar(adocao);
	
}

public List<Adocoes> listarAdocoes() throws SQLException{ //aprimorar
	return adocaoRepositoryA.listarAdocoes();
}


}
