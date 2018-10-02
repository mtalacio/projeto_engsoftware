package customexceptions;

@SuppressWarnings("serial")
public class MatriculaInvalidaException extends Exception {

	public MatriculaInvalidaException() {
		super("Matrícula Eleitorial Inválida.");
	}

	public MatriculaInvalidaException(String message) {
		super(message);
	}

}
