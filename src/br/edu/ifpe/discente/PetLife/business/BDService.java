package br.edu.ifpe.discente.PetLife.business;

import java.sql.SQLException;

import br.edu.ifpe.discente.PetLife.data.AnimaisRepository;
import br.edu.ifpe.discente.PetLife.data.RecursosRepository;

public class BDService {
	
	AnimaisRepository repositoryA = new AnimaisRepository();
	RecursosRepository repositoryR = new RecursosRepository();
	public BDService() {
		this.repositoryA = new AnimaisRepository();
		this.repositoryR = new RecursosRepository();
	}
	
	public void iniciarBD() throws SQLException { //aprimorar
		repositoryA.iniciarBd();
		repositoryR.iniciarBdRecursos();
	}
	
	

}
