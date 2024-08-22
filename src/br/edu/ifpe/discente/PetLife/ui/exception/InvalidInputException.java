package br.edu.ifpe.discente.PetLife.ui.exception;

public class InvalidInputException extends Exception {
	
	public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }

}
