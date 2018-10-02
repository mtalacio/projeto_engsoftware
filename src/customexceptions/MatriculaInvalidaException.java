package customexceptions;

@SuppressWarnings("serial")
public class MatriculaInvalidaException extends Exception {

	public MatriculaInvalidaException() {
		super("Matr�cula Eleitorial Inv�lida.");
	}

	public MatriculaInvalidaException(String message) {
		super(message);
	}

}
