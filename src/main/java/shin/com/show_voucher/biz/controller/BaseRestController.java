/*
*
*/

package shin.com.show_voucher.biz.controller;

import lombok.extern.slf4j.Slf4j;
import shin.com.show_voucher.biz.vo.ResultVo;
import shin.com.show_voucher.exception.ExceptionBase;
import shin.com.show_voucher.exception.http.ApiExecutionException;
import shin.com.show_voucher.exception.http.BadRequestException;
import shin.com.show_voucher.exception.http.ForbiddenException;
import shin.com.show_voucher.exception.http.UnauthorizedReqeustException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@Slf4j
public class BaseRestController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private LocaleResolver localeResolver;

	@ExceptionHandler(ExceptionBase.class)
	public ResponseEntity<?> handleBaseException(HttpServletRequest req, Exception ex) {
		log.error(ex.getLocalizedMessage());
		if(ex instanceof BadRequestException){
			String errorMsg = getMsg(req, ex);
			return badReq(errorMsg);
		} else if (ex instanceof UnauthorizedReqeustException) {
			String errorMsg = getMsg(req, ex);
			return auth(errorMsg);
		} else if (ex instanceof ApiExecutionException) {
			String errorMsg = getMsg(req, ex);
			return auth(errorMsg);
		} else if (ex instanceof ForbiddenException) {
			String errorMsg = getMsg(req, ex);
			return forbiden(errorMsg);
		}else {
			String errorMsg = getMsg(req, ex);
			return forbiden(errorMsg);
		}
	}

	private String getMsg(HttpServletRequest req,Exception ex) {
		if(ex instanceof ExceptionBase){
			ExceptionBase e = (ExceptionBase) ex;
			String msg = e.getMessage();
			String[] args = e.getArgs();
			try {
				if (args != null) {
					return messageSource.getMessage(msg, args, localeResolver.resolveLocale(req));
				}
				return msg;
			} catch (Exception e1) {
				return e1.getLocalizedMessage();
			}
		}
		return ex.getLocalizedMessage();
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(HttpServletRequest req, Exception ex) {
		String msg = ex.getMessage();
		log.warn(msg);

		return badReq("error.bad.request");
	}


	/**
	 * 성공
	 * @param data
	 * @return
	 */
	protected ResponseEntity<?> success(Object data) {
		ResultVo restResult = new ResultVo();
		restResult.setCode("200");
		restResult.setMessage("");
		restResult.setData(data);
		restResult.setDatetime(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		return new ResponseEntity<>(restResult, HttpStatus.OK);
	}

	protected ResponseEntity<?> page(Object data,long total,int offset) {
		ResultVo restResult = new ResultVo();
		restResult.setCode("200");
		restResult.setMessage("");
		restResult.setOffset(offset);
		restResult.setTotal(total);
		restResult.setData(data);
		restResult.setDatetime(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		return new ResponseEntity<>(restResult, HttpStatus.OK);
	}

	/**
	 * 성공
	 * @param data
	 * @return
	 */
	protected ResponseEntity<?> success(Object data,String offset,String size) {
		return success(data , offset , size , 0);
	}

	protected ResponseEntity<?> success(Object data,String offset,String size , int total) {
		ResultVo restResult = new ResultVo();
		restResult.setCode("200");
		restResult.setMessage("");
		restResult.setData(data);
		restResult.setOffset(Integer.parseInt(offset));
		restResult.setSize(size);
		restResult.setTotal(total);
		restResult.setDatetime(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		return new ResponseEntity<>(restResult, HttpStatus.OK);
	}

	/**
	 * Fail
	 * @return
	 */
	protected ResponseEntity<?> fail(String failMsg) {
		ResultVo restResult = new ResultVo();
		restResult.setCode("400");
		restResult.setMessage(failMsg);
		restResult.setDatetime(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		return new ResponseEntity<>(restResult, HttpStatus.OK);
	}

	/**
	 * Fail
	 * @return
	 */
	protected ResponseEntity<?> badReq(String failMsg) {
		ResultVo restResult = new ResultVo();
		restResult.setCode("400");
		restResult.setMessage(failMsg);
		restResult.setDatetime(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		return new ResponseEntity<>(restResult, HttpStatus.OK);
	}

	/**
	 * Fail
	 * @return
	 */
	protected ResponseEntity<?> auth(String failMsg) {
		ResultVo restResult = new ResultVo();
		restResult.setCode("401");
		restResult.setMessage(failMsg);
		restResult.setDatetime(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		return new ResponseEntity<>(restResult, HttpStatus.UNAUTHORIZED);
	}

	/**
	 * Fail
	 * @return
	 */
	protected ResponseEntity<?> forbiden(String failMsg) {
		ResultVo restResult = new ResultVo();
		restResult.setCode("403");
		restResult.setMessage(failMsg);
		restResult.setDatetime(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		return new ResponseEntity<>(restResult, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Object processValidationError(MethodArgumentNotValidException ex) {
		return badReq(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
	}

	protected void ipCheck(HttpServletRequest request) throws BadRequestException {
		boolean isCheck = true;
		if (!isCheck) {
			throw new BadRequestException("invalide ip");
		}
	}

}