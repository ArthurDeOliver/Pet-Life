package br.edu.ifpe.discente.PetLife.business;

import java.sql.SQLException;

import br.edu.ifpe.discente.PetLife.data.AnimaisRepository;
import br.edu.ifpe.discente.PetLife.data.RecursosRepository;
import br.edu.ifpe.discente.PetLife.data.AdocaoRepository;


public class BDService {
	
	AnimaisRepository repositoryA = new AnimaisRepository();
	RecursosRepository repositoryR = new RecursosRepository();
	AdocaoRepository adocaorepositoryA = new AdocaoRepository();
	
	public BDService() {
		this.repositoryA = new AnimaisRepository();
		this.repositoryR = new RecursosRepository();
		this.adocaorepositoryA = new AdocaoRepository();
	}
	
	public void iniciarBD() throws SQLException { //aprimorar
		repositoryA.iniciarBd();
		repositoryR.iniciarBdRecursos();
		adocaorepositoryA.iniciarBdAdocoes();
	}
	
	

}
