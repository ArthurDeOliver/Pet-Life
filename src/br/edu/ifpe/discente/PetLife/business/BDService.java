package br.edu.ifpe.discente.PetLife.business;

import java.sql.SQLException;

import br.edu.ifpe.discente.PetLife.data.AnimaisRepository;
import br.edu.ifpe.discente.PetLife.data.RecursosRepository;

public class BDService {
	
	AnimaisRepository repositoryA = new AnimaisRepository();
	RecursosRepository repositoryB = new RecursosRepository();
	public BDService() {
		this.repositoryA = new AnimaisRepository();
		this.repositoryB = new RecursosRepository();
	}
	
	public void iniciarBD() throws SQLException { //aprimorar
		repositoryA.iniciarBd();
		repositoryB.iniciarBdRecursos();
	}
	
	

}
