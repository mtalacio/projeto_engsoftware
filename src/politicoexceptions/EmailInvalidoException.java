package politicoexceptions;

@SuppressWarnings("serial")
public class EmailInvalidoException extends Exception {
	
	public EmailInvalidoException() {
		super("E-mail Inválido");
	}
}
