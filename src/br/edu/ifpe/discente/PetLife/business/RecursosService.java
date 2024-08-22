package br.edu.ifpe.discente.PetLife.business;
import java.sql.SQLException;

import br.edu.ifpe.discente.PetLife.data.RecursosRepository;
import br.edu.ifpe.discente.PetLife.ui.entities.Medicamentos;
import br.edu.ifpe.discente.PetLife.ui.entities.Racoes;
import br.edu.ifpe.discente.PetLife.ui.entities.Vacinas;

public class RecursosService {
	
 private RecursosRepository repositoryR;
 
 	public RecursosService() {			
		this.repositoryR = new RecursosRepository();
	}
    
 	public void criarVacina(Vacinas vacina) throws SQLException {
 
	this.repositoryR.criarVacina(vacina);
 	}
	
 	public void criarMedicamento(Medicamentos medicamento) throws SQLException {
 		this.repositoryR.criarMedicamento(medicamento);
 	}
 	
 	public void criarRacao(Racoes racao) throws SQLException {
 		this.repositoryR.criarRacao(racao);
 	}
}