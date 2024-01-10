/*
*
*/

package shin.com.show_voucher.exception.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import shin.com.show_voucher.common.code.ErrorCd;
import shin.com.show_voucher.exception.ExceptionBase;

/**
 *
 */
@ResponseStatus(value= HttpStatus.UNAUTHORIZED, reason="Unauthorized Reqeust")  // 401
public class UnauthorizedReqeustException extends ExceptionBase {

	/*  */
	private static final long serialVersionUID = -8562066640200225572L;

	public UnauthorizedReqeustException() {
		super("error.CO401");
	}
	public UnauthorizedReqeustException(String errorCode,String... args) {
		super(errorCode,args);
	}
	public UnauthorizedReqeustException(ErrorCd errorCd) {
		super(errorCd.name());
	}
	public UnauthorizedReqeustException(String errorCode) {
		super(errorCode);
	}

}
