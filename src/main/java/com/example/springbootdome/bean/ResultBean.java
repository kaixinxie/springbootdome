package com.example.springbootdome.bean;

import com.example.springbootdome.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResultBean<T> implements Serializable {
  
  private static final long serialVersionUID = 1L;
  private Boolean success;
  
  private String code;
  
  private String message;
  
  private T data;
  
  /**
   * 构造器私有
   */
  private ResultBean() {
  }
  
  /**
   * 通用返回成功
   */
  public static ResultBean ok() {
    ResultBean resultBean = new ResultBean();
    resultBean.setSuccess(ResultCode.OK.getSuccess());
    resultBean.setCode(ResultCode.OK.getCode());
    resultBean.setMessage(ResultCode.OK.getMsg());
    return resultBean;
  }
  
  /**
   * 通用返回失败，未知错误
   *
   * @return
   */
  public static ResultBean failure() {
    ResultBean resultBean = new ResultBean();
    resultBean.setSuccess(ResultCode.NG.getSuccess());
    resultBean.setCode(ResultCode.NG.getCode());
    resultBean.setMessage(ResultCode.NG.getMsg());
    return resultBean;
  }
  
  /**
   * 通用返回失败，未知错误
   *
   * @return
   */
  public static ResultBean failure(String msg) {
    ResultBean resultBean = new ResultBean();
    resultBean.setSuccess(ResultCode.NG.getSuccess());
    resultBean.setCode(ResultCode.NG.getCode());
    resultBean.setMessage(msg);
    return resultBean;
  }
  
  /**
   * 通用返回失败，未知错误
   *
   * @return
   */
  public static ResultBean failure(String code, String msg) {
    ResultBean resultBean = new ResultBean();
    resultBean.setSuccess(ResultCode.NG.getSuccess());
    resultBean.setCode(code);
    resultBean.setMessage(msg);
    return resultBean;
  }
  
  /**
   * 设置结果，形参为结果枚举
   *
   * @param result
   * @return
   */
  public static ResultBean setResult(ResultCode result) {
    ResultBean resultBean = new ResultBean();
    resultBean.setSuccess(result.getSuccess());
    resultBean.setCode(result.getCode());
    resultBean.setMessage(result.getMsg());
    return resultBean;
  }
  
  /**
   * 通用设置data
   *
   * @param value
   * @return
   */
  public ResultBean<T> data(T value) {
    this.data = value;
    return this;
  }
  
  /**
   * 自定义状态信息
   *
   * @param message
   * @return
   */
  public ResultBean message(String message) {
    this.setMessage(message);
    return this;
  }
  
  /**
   * 自定义状态码
   *
   * @param code
   * @return
   */
  public ResultBean code(String code) {
    this.setCode(code);
    return this;
  }
  
  /**
   * 自定义返回结果
   *
   * @param success
   * @return
   */
  public ResultBean success(Boolean success) {
    this.setSuccess(success);
    return this;
  }
}