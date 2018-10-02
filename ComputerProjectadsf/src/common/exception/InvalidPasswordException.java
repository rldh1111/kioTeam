package common.exception;

//현재 비번을 잘못 입력했을 때 발생시킬 예외
public class InvalidPasswordException extends RuntimeException {

	public InvalidPasswordException(String message) {
		super(message);
	}

}
