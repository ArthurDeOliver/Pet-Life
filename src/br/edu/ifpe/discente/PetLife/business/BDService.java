package br.edu.ifpe.discente.PetLife.business;

import java.sql.SQLException;

import br.edu.ifpe.discente.PetLife.data.AnimaisRepository;

public class BDService {
	
	AnimaisRepository repositoryA = new AnimaisRepository();
	
	public BDService() {
		this.repositoryA = new AnimaisRepository();
	}
	
	public void iniciarBD() throws SQLException { //aprimorar
		repositoryA.iniciarBd();
	}
	

}
