package customexceptions;

@SuppressWarnings("serial")
public class NomeInvalidoException extends Exception {

	public NomeInvalidoException() {
		super("Nome Inv�lido.");
	}

	public NomeInvalidoException(String arg0) {
		super(arg0);
	}
}
