
package br.edu.ifpe.discente.PetLife.business;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpe.discente.PetLife.data.AnimaisRepository;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;

public class AnimaisService {
	
	private AnimaisRepository dadosAnimais;
	
	public AnimaisService() {
		
		this.dadosAnimais = new AnimaisRepository();
	}
	
	public void criarAnimal (Animais animal) throws SQLException { //aprimorar
		dadosAnimais.criarAnimal(animal);
		
	}
	
	public List<Animais> retornarAnimal() throws SQLException{ //aprimorar
		return dadosAnimais.listarTodosAnimais();
		
	}
	
		// regras de negócio aqui
}
