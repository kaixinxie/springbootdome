package com.example.springbootdome.handler;


import com.example.springbootdome.bean.ResultBean;
import com.example.springbootdome.enums.BizResultCodeEnum;
import com.example.springbootdome.utils.ExceptionUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Priority;

@ControllerAdvice
@Priority(1)
public class ExceptionAdviceHandler {
  
  
  @ExceptionHandler(Exception.class)
  public @ResponseBody
  Object handleException(Exception ex) throws Exception {
    ExceptionUtil.logExceptionInfo(ex);
    return ResultBean.failure(BizResultCodeEnum.UNKNOW_ERROR.getCode(), BizResultCodeEnum.UNKNOW_ERROR.getDescription());
  }
}
