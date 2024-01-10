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
@ResponseStatus(value= HttpStatus.FORBIDDEN, reason="Reqeust Forbidden")  // 403
public class ForbiddenException extends ExceptionBase {

	/*  */
	private static final long serialVersionUID = 4382922857122470846L;

	public ForbiddenException() {
		super("error.403");
	}
	public ForbiddenException(String errorCode,String... args) {
		super(errorCode,args);
	}
	public ForbiddenException(ErrorCd errorCd) {
		super(errorCd.name());
	}
	public ForbiddenException(String errorCode) {
	    super(errorCode);
	}

}
