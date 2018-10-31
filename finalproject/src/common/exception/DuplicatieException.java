package common.exception;

//중복 시 발생처리할 예외.
public class DuplicatieException extends RuntimeException {

	public DuplicatieException(String message) {
		super(message);
	}
}
