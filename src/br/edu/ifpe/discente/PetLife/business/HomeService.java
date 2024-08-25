package br.edu.ifpe.discente.PetLife.business;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifpe.discente.PetLife.data.AnimaisRepository;
import br.edu.ifpe.discente.PetLife.ui.entities.Animais;
import br.edu.ifpe.discente.PetLife.data.RecursosRepository;
import br.edu.ifpe.discente.PetLife.ui.entities.Medicamentos;
import br.edu.ifpe.discente.PetLife.ui.entities.Racoes;
import br.edu.ifpe.discente.PetLife.ui.entities.Vacinas;
import br.edu.ifpe.discente.PetLife.data.AdocaoRepository;
import br.edu.ifpe.discente.PetLife.ui.entities.Adocoes;

public class HomeService {
	
	AnimaisService servicoAnimal = new AnimaisService();
	AdocaoService servicoAdocao = new AdocaoService();
	RecursosService servicoRecurso = new RecursosService();
	
	public List<Animais> retornarAnimal() throws SQLException{ 
		return servicoAnimal.retornarAnimal();
		
	}
	
	public List<Adocoes> listarAdocoes() throws SQLException{ 
		return servicoAdocao.listarAdocoes();
	}
	
	public List<Racoes> retornarTodasRacoes() throws SQLException {
		return servicoRecurso.retornarTodasRacoes();
	}

	public List<Medicamentos> retornarTodosMedicamentos() throws SQLException {
		return servicoRecurso.retornarTodosMedicamentos();
	}
	
	public List<Vacinas> retornarTodasVacinas() throws SQLException {
		return servicoRecurso.retornarTodasVacinas();
	}
	
	
}
