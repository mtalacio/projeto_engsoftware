package politicoexceptions;

@SuppressWarnings("serial")
public class NomeInvalidoException extends Exception {

	public NomeInvalidoException() {
		super("Nome Inválido.");
	}
}
