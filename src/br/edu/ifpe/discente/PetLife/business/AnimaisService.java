
package br.edu.ifpe.discente.PetLife.business;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpe.discente.PetLife.data.AnimaisRepository;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;

public class AnimaisService {
	
	private AnimaisRepository repositoryA;
	
	public AnimaisService() {
		
		this.repositoryA = new AnimaisRepository();
	}
	
	public void criarAnimal (Animais animal) throws SQLException { //aprimorar
		repositoryA.criarAnimal(animal);
		
	}
	
	public List<Animais> retornarAnimal() throws SQLException{ //aprimorar
		return repositoryA.listarTodosAnimais();
		
	}
	
	public List<Animais> retornarAnimaisAptos() throws SQLException{ //aprimorar
		return repositoryA.listarAnimaisAptos();
		
	}
	
	public int retornarID(Animais animal)throws SQLException{
		return repositoryA.retornarID(animal);
	}
	
	public void atualizarAnimal(String nome, int idade, String tipo, String raca, int racao, String status, String vacina, String foto, int id) throws SQLException {
		repositoryA.atualizarAnimal(nome, idade, tipo, raca, racao, status, vacina, foto, id);
	}
	
	public void deletarAnimal(String nome) throws SQLException {
		repositoryA.deletarAnimal(nome);
	}
	
	
		// TODO regras de negócio
}
