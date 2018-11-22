package politicoexceptions;

import java.time.format.DateTimeParseException;

@SuppressWarnings("serial")
public class DataInvalidaException extends DateTimeParseException {

	public DataInvalidaException(String message, DateTimeParseException ex) {
		super(message, ex.getParsedString(), ex.getErrorIndex());
		
	}

}
