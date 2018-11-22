package politicoexceptions;

@SuppressWarnings("serial")
public class CpfInvalidoException extends Exception {

	public CpfInvalidoException() {
		super("CPF Inválido");
	}
	
}
