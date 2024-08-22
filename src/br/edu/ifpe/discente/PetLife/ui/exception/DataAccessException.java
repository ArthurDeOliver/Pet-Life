package br.edu.ifpe.discente.PetLife.ui.exception;

public class DataAccessException extends Exception {

	public DataAccessException(String message) {
		super(message);
	}

	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}

}
