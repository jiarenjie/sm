package com.meiling.conf;

import com.meiling.ctl.TestCtl;
import com.meiling.entity.Result;
import com.meiling.exceptions.BusinessException;
import com.meiling.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalDefultExceptionHandler {
	private static Logger LOGGER = LoggerFactory.getLogger(TestCtl.class);

	//声明要捕获的异常
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result defultExcepitonHandler(HttpServletRequest request, Exception e) {
		LOGGER.error("错误信息: "+e.getMessage());
		if(e instanceof BusinessException) {
			BusinessException businessException = (BusinessException)e;
			return ResultUtil.error(businessException.getMessage());
		}
		//未知错误
		return ResultUtil.error(-1, "系统异常："+e.getMessage());

	}
}
