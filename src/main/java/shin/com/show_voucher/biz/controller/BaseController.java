/*
*
*/

package shin.com.show_voucher.biz.controller;

import lombok.extern.slf4j.Slf4j;
import shin.com.show_voucher.biz.vo.SessionUserVo;
import shin.com.show_voucher.exception.ExceptionBase;
import shin.com.show_voucher.exception.http.ApiExecutionException;
import shin.com.show_voucher.exception.http.BadRequestException;
import shin.com.show_voucher.exception.http.UnauthorizedReqeustException;
import shin.com.show_voucher.utils.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class BaseController {

	private final String ERR_400 = "error/400";
	private final String ERR_401 = "error/401";
	private final String ERR_403 = "error/401";
	private final String ATTR_NM = "msg";

	@ExceptionHandler(ExceptionBase.class)
	public ModelAndView handleBaseException(HttpServletRequest req, Exception ex) {
		ModelAndView mv = new ModelAndView(ERR_400);
		log.error(ex.getLocalizedMessage());
		if(ex instanceof BadRequestException){
			String errorMsg = getMsg(req, ex);
			mv.addObject(ATTR_NM, errorMsg);
			mv.setViewName(ERR_400);
		} else if (ex instanceof UnauthorizedReqeustException) {
			String errorMsg = getMsg(req, ex);
			mv.addObject(ATTR_NM, errorMsg);
			mv.setViewName(ERR_401);
		} else if (ex instanceof ApiExecutionException) {
			String errorMsg = getMsg(req, ex);
			mv.addObject(ATTR_NM, errorMsg);
			mv.setViewName(ERR_401);
		} else {
			String errorMsg = getMsg(req, ex);
			mv.addObject(ATTR_NM, errorMsg);
			mv.setViewName(ERR_403);
		}
		return mv;
	}

	private String getMsg(HttpServletRequest req,Exception ex) {
		if(ex instanceof ExceptionBase){
			ExceptionBase e = (ExceptionBase) ex;
			String msg = e.getMessage();
			String[] args = e.getArgs();
			try {
				if (args != null) {
					return msg;
				}
				return msg;
			} catch (Exception e1) {
				return e1.getLocalizedMessage();
			}
		}
		return ex.getLocalizedMessage();
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(HttpServletRequest req, Exception ex) {
		String msg = ex.getMessage();
		log.error(msg);
		ModelAndView mv = new ModelAndView(ERR_400);
		mv.addObject(ATTR_NM, msg);
		return mv;
	}

	@ExceptionHandler(ApiExecutionException.class)
	public ModelAndView handleApiException(HttpServletRequest req, Exception ex) {
		String msg = ex.getMessage();
		log.warn(msg);
		ModelAndView mv = new ModelAndView(ERR_400);
		mv.addObject(ATTR_NM, msg);
		return mv;
	}


	protected SessionUserVo checkLogin(HttpServletRequest request) throws UnauthorizedReqeustException {
		SessionUserVo sessionUserVo = SessionUtil.getSessionUser(request);
		if (sessionUserVo == null) {
			throw new UnauthorizedReqeustException("로그인 후 이용이 가능합니다.");
		}
		return sessionUserVo;
	}


	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ModelAndView processValidationError(MethodArgumentNotValidException ex) {
		ModelAndView mv = new ModelAndView(ERR_400);
		mv.addObject(ATTR_NM, ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
		return mv;
	}

}