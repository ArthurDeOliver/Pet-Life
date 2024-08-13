package br.edu.ifpe.discente.PetLife.business;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpe.discente.PetLife.data.TutorRepository;

public class TutorService {
	
	private TutorRepository tutorRepositoryA;
	
public TutorService() {
		
		this.tutorRepositoryA = new TutorRepository();
	}

}
