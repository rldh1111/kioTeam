
package common.exception;

//비밀변호 변경할 떄 그 사용자정보가 없을 시.
public class UserNotFountException extends RuntimeException {

	public UserNotFountException(String message) {
		super(message);
	}
}
