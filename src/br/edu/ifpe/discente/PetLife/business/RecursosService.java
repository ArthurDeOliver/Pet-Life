package br.edu.ifpe.discente.PetLife.business;
import java.sql.SQLException;

import br.edu.ifpe.discente.PetLife.data.RecursosRepository;
import br.edu.ifpe.discente.PetLife.ui.entities.Vacinas;

public class RecursosService {
	
 private RecursosRepository repositoryR;
 
 	public RecursosService() {			
		this.repositoryR = new RecursosRepository();
	}
    
 	public void criarVacina(Vacinas vacina) throws SQLException {
 
	this.repositoryR.criarVacina(vacina);
 	}
	
}