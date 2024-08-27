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
	
	public void criarAnimal (Animais animal) throws SQLException { 
		if (animal.getNome() == null || animal.getNome().isEmpty() || Integer.toString(animal.getIdade()).equals("")) {
		        throw new IllegalArgumentException("Todos os campos de texto são obrigatórios.");
		    }
		
		    if (animal.getIdade() < 0) {
		        throw new IllegalArgumentException("A idade deve ser um número positivo.");
		    }

		    if (animal.getRacao() < 0) {
		        throw new IllegalArgumentException("A quantidade de ração deve ser um número positivo.");
		    }
			
		    repositoryA.criarAnimal(animal);
		
		
	}
	
	public List<Animais> retornarAnimal() throws SQLException{ //aprimorar
		return repositoryA.listarTodosAnimais();
		
	}
	
	public List<Animais> retornarAnimaisAptos() throws SQLException{ //aprimorar
		return repositoryA.listarAnimaisAptos();
		
	}
	
		
	public void atualizarAnimal(String nome, int idade, String tipo, String raca, int racao, String status, int id) throws SQLException {
			if (nome == null || nome.isEmpty() || Integer.toString(idade).equals("")) {
		        throw new IllegalArgumentException("Todos os campos de texto são obrigatórios.");
		    }
			

		    if (idade < 0) {
		        throw new IllegalArgumentException("A idade deve ser um número positivo.");
		    }

		    if (racao < 0) {
		        throw new IllegalArgumentException("A quantidade de ração deve ser um número positivo.");
		    }
 
		    
		    repositoryA.atualizarAnimal(nome, idade, tipo, raca, racao, status, id);
	}
	
	public void deletarAnimal(int id) throws SQLException {
		repositoryA.deletarAnimal(id);
	}
	
	
		// TODO regras de negócio
}
